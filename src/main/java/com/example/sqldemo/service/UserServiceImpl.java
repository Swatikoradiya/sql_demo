package com.example.sqldemo.service;

import com.example.sqldemo.config.NullAwareBeanUtils;
import com.example.sqldemo.constant.MessageConstant;
import com.example.sqldemo.decorator.UserRequest;
import com.example.sqldemo.entity.Roles;
import com.example.sqldemo.entity.User;
import com.example.sqldemo.enums.Role;
import com.example.sqldemo.exception.NotFoundException;
import com.example.sqldemo.repository.RoleRepository;
import com.example.sqldemo.repository.UserRepository;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.InvocationTargetException;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final NullAwareBeanUtils beanUtils;

    private final RoleRepository roleRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, NullAwareBeanUtils beanUtils, RoleRepository roleRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.beanUtils = beanUtils;
        this.roleRepository = roleRepository;
    }

    @Override
    public User updateUser(Long id, UserRequest userRequest) {
        User user = getUser(id);
        try {
            beanUtils.copyProperties(user, userRequest);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return userRepository.save(user);
    }

    @Override
    public User addUser(UserRequest userRequest) {
        if (ObjectUtils.isEmpty(userRequest) && StringUtils.isEmpty(userRequest.getEmail())) {
            throw new NotFoundException(MessageConstant.INVALID_DATA);
        }
        User user = modelMapper.map(userRequest, User.class);

        Roles role = new Roles();
        role.setName(Role.USER);

        roleRepository.save(role);
//        user.setRoles(role);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUser(id);
        user.setSoftDelete(true);
        userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findByIdAndSoftDeleteIsFalse(id).orElseThrow(() -> new NotFoundException(MessageConstant.USER_NOT_FOUND));
    }
}
