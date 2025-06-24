package com.example.assignment_2.Service;
import com.example.assignment_2.Entity.User;
import com.example.assignment_2.Repository.UserRepository;
import com.example.assignment_2.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    public void registerUser(User user) {
        userRepository.addUser(user);
    }
}
