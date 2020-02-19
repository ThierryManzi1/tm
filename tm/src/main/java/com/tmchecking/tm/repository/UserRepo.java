package com.tmchecking.tm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tmchecking.tm.domain.Credential;

@Repository
public interface UserRepo extends JpaRepository<Credential, Long>{
	
	Optional<Credential> findByUsername(String username);
	
	@Query("Select m from Credential m where m.username = :user")
	Credential loadUser(@Param("user") String user);
	
	//Credential findByUsernameBetween
	
}
