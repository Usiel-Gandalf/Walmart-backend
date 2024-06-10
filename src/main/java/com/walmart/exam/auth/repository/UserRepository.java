package com.walmart.exam.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmart.exam.auth.models.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByUsername(String username); 
}
