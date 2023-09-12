package com.example.sqldemo.service;

import com.example.sqldemo.entity.Roles;
import com.example.sqldemo.enums.Role;

public interface RoleService {

    Roles updateRoles(Long id, Role name);
}
