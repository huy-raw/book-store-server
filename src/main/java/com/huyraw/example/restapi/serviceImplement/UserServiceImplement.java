package com.huyraw.example.restapi.serviceImplement;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.huyraw.example.restapi.entity.User;
import com.huyraw.example.restapi.repository.UserRepository;
import com.huyraw.example.restapi.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
@AllArgsConstructor
public class UserServiceImplement implements UserService, UserDetailsService {

    private UserRepository userRepository;

    @Override
    public User findUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);

        if (!user.isPresent()) {
            log.error(String.format("No such user with %s: %s", "email", email));
            throw new NoResultException("Can not find user with email " + email);
        }
        log.info(String.format("Founded user with %s: %s", "email", email));

        return user.get();
    }

    @Override
    public User addNewUser() {
        String email = "demo@gmail.com";
        Optional<User> userExist = userRepository.findUserByEmail(email);
        if (userExist.isPresent()) {
            log.error(String.format("Email already taken when use: %s", email));
            throw new IllegalStateException("Email already taken!");
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = userRepository.findAll();
        if (userList.size() == 0) {
            log.info("Can't find any users in the repository");
            throw new IllegalStateException("Can't find any users in the repository");
        }
        log.info(String.format("Get %d users", userList.stream().count()));
        return userList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeUserByEmail(String email) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            log.info(String.format("User have id %s not found", id));
            throw new IllegalStateException(String.format("User have id %s not found", id));
        }
    }

}
