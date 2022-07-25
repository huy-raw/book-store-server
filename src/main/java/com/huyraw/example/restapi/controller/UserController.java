package com.huyraw.example.restapi.controller;

import java.util.List;

import javax.validation.constraints.Email;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huyraw.example.restapi.entity.User;
import com.huyraw.example.restapi.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @GetMapping(value = "/email")
    public ResponseEntity<User> getUserByEmail(
        @Validated @Email @PathVariable("email") String email) {
        return ResponseEntity.ok().body(userService.findUserByEmail(email));
    }
}
