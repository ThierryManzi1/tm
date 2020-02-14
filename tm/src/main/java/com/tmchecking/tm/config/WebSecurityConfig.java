package com.tmchecking.tm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.tmchecking.tm.service.impl.UserServiceImpl;


@Configuration
//@Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userServiceImpl).passwordEncoder(passwordEncoder());
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        /*
           The authorizeRequests configuration is where we specify what roles are allowed access to what URLs.
            One of the most important things is the order of the intercept-urls,
            the most catch-all[default] type patterns should at the bottom of the list as the matches are executed
            in the order they are configured below.   
 			(anyRequest()) should always be at the bottom of the list.     
         */
           .authorizeRequests()
                .antMatchers( "/login**" ).permitAll()
                .antMatchers( "/uploadFile" ).hasRole( "ADMIN" )
                .antMatchers( "/schedule" ).hasAnyRole( "USER" )
                .antMatchers( "/managestudent" ).hasAnyRole( "ADMIN" )
                .anyRequest().permitAll()
             .and()
            
				/*
				 * This is where we configure our login form. 
				 * loginPage: the page that contains the login screen
				 * login-processing-url: this is the URL to which the login form should be submitted 
				 * e.g., [<form:form action=login-processing-url]
				 * defaultSuccessUrl: the URL to which the user will be redirected if login is successful 
				 * failureUrl: the URL to which the user will be redirected if  failed login
				 */
             .formLogin()
                .loginPage( "/login" )
                .loginProcessingUrl( "/postlogin" )
                .defaultSuccessUrl( "/schedule" )
                .failureUrl( "/loginfailed" )
                .permitAll()
                 .and()
 
				/*
				 * This is where the logout page and process is configured. 
				 * The logoutRequestMatcher is the URL to send the user to in order to logout, 
				 * e.g., <a href="<spring:url  value="/dologout" />">Logout</a> 
				 * the logout-success-url is where to go to if the logout is successful, and
				 *  the delete-cookies and invalidate-session make sure that we clean up after
				 * logout
				 */ 
             .logout()
                .logoutRequestMatcher( new AntPathRequestMatcher( "/dologout" ) )
                .logoutSuccessUrl( "/logout" )
                .deleteCookies( "JSESSIONID" )
                .invalidateHttpSession( true )
                
                .and()
                // access-denied-page: this is the page users will be
                // redirected to when they try to access protected areas.
                .exceptionHandling()
                    .accessDeniedPage( "/accessDenied" );
	}
	
	

}
