package com.example.assignment_2.API;
import com.example.assignment_2.Entity.Role;
import com.example.assignment_2.Service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/roles")
public class RoleAPI {
    public RoleService roleService;
    public RoleAPI(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable int id) {
        return roleService.getById(id);
    }
}

