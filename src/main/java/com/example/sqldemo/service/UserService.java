package com.example.sqldemo.service;

import com.example.sqldemo.decorator.UserRequest;
import com.example.sqldemo.entity.Roles;
import com.example.sqldemo.entity.User;
import com.example.sqldemo.enums.Role;

import java.util.List;

public interface UserService {

    User addUser(UserRequest userRequest);

    User updateUser(Long id, UserRequest userRequest);

    User getUser(Long id);

    void deleteUser(Long id);

    Roles updateRoles(Long id, Role name);

    List<User> getAllUser();
}
