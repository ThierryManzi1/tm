package com.tmchecking.tm.factory;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public class UserDemoNative {
	
	@Autowired
	private EntityManager entityManger;
	
	private void name() {
		entityManger.createNativeQuery("Select * from credentials_tbl where username = :user")
		.setParameter("user", "philip")
		.getFirstResult();
		
	}

}
