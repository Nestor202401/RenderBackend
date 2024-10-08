package com.member.service;

import com.member.bean.users;
import com.member.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<users> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<users> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public users createUser(users user) {
        return userRepository.save(user);
    }

    public users updateUser(Integer userId, users user) {
        user.setUserId(userId);
        return userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
