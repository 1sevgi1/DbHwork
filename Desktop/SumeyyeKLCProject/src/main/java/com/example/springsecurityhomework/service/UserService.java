package com.example.springsecurityhomework.service;

import com.example.springsecurityhomework.model.User;
import com.example.springsecurityhomework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public boolean authenticate(String email, String password) {
        return userRepository.findByEmail(email)
            .map(user -> user.getPassword().equals(password)) // Add proper password encryption in real projects
            .orElse(false);
    }
}
