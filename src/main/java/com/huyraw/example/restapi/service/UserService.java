package com.huyraw.example.restapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.huyraw.example.restapi.entity.User;


@Service
public interface UserService {
    User findUserByEmail(String email);

    User addNewUser();

    List<User> getAllUser();

    void removeUserByEmail(String email);
    void removeUserById(String id);

}
