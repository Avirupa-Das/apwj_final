package com.example.assignment_2.Service;
import com.example.assignment_2.Entity.Role;
import com.example.assignment_2.Repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    public RoleRepository roleRepository;
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.getAll();
    }

    public Role getById(int id) {
        return roleRepository.getById(id);
    }
}
