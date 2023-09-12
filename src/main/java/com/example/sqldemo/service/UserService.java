package com.example.sqldemo.service;

import com.example.sqldemo.decorator.UserRequest;
import com.example.sqldemo.entity.User;

public interface UserService {

    User addUser(UserRequest userRequest);

    User updateUser(Long id, UserRequest userRequest);

    User getUser(Long id);

    void deleteUser(Long id);
}
