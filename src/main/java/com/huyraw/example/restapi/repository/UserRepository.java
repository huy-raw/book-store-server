package com.huyraw.example.restapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.huyraw.example.restapi.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "" + "SELECT s FROM User s WHERE s.email LIKE  ?1" +"")
    Optional<User> findUserByEmail(String email);
}