package com.tmchecking.tm.repository;

import java.util.Optional;

import com.tmchecking.tm.domain.Credential;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<Credential,Long>{

    Optional<Credential> findByUsername(String username);
    
}