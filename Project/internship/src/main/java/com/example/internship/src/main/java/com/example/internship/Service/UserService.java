package com.example.internship.Service;

import com.example.internship.Entity.User;
import com.example.internship.Entity.Role;
import com.example.internship.Repository.UserRepo;
import com.example.internship.Repository.RoleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public UserRepo userRepo;
    public RoleRepo roleRepo;

    public UserService(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.getAll();
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public void approveUser(int id, boolean approved) {
        userRepo.updateApproval(id, approved);
    }

    public void deleteUser(int id) {
        userRepo.delete(id);
    }

    public void createUser(User user) {
        userRepo.insert(user);
    }

    public List<Role> getAllRoles() {
        return roleRepo.getAll();
    }
}