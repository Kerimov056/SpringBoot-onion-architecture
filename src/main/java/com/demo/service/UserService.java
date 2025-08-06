package com.demo.service;

import org.springframework.stereotype.Service;

import com.demo.entities.User;
import com.demo.iRepository.IUserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}