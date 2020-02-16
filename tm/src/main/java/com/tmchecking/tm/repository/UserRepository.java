package com.tmchecking.tm.repository;

import java.util.Optional;

import com.tmchecking.tm.domain.Credential;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<Credential,Long>{

    Optional<Credential> findByUsername(String username);

    @Query("Select m from Credential m where m.username = :uname")
    Credential findUser(@Param("uname") String uname);
    
}