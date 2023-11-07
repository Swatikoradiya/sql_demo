package com.example.sqldemo.service;

import com.example.sqldemo.entity.Roles;
import com.example.sqldemo.enums.Role;
import com.example.sqldemo.exception.NotFoundException;
import com.example.sqldemo.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Roles updateRoles(Long id, Role name) {
        Roles role = roleRepository.findById(id).orElseThrow(() -> new NotFoundException("ROle not found"));
        role.setName(name);
        return roleRepository.save(role);
    }

    public abstract void abc();
}
