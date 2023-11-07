package com.example.sqldemo.controller;

import com.example.sqldemo.constant.MessageConstant;
import com.example.sqldemo.decorator.DataResponse;
import com.example.sqldemo.decorator.ListResponse;
import com.example.sqldemo.decorator.Response;
import com.example.sqldemo.decorator.UserRequest;
import com.example.sqldemo.entity.User;
import com.example.sqldemo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public DataResponse<User> addUser(@RequestBody UserRequest userRequest) {
        DataResponse<User> dataResponse = new DataResponse<>();
        dataResponse.setData(userService.addUser(userRequest));
        dataResponse.setResponse(Response.getCreatedResponse(MessageConstant.USER_ADDED_SUCCESSFULLY));
        return dataResponse;
    }

    @PostMapping(value = "/update/{id}")
    public DataResponse<User> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        DataResponse<User> dataResponse = new DataResponse<>();
        dataResponse.setData(userService.updateUser(id, userRequest));
        dataResponse.setResponse(Response.getSuccessResponse());
        return dataResponse;
    }

    @GetMapping(value = "/get/{id}")
    public DataResponse<User> getUser(@PathVariable Long id) {
        DataResponse<User> dataResponse = new DataResponse<>();
        dataResponse.setData(userService.getUser(id));
        dataResponse.setResponse(Response.getSuccessResponse());
        return dataResponse;
    }

    @DeleteMapping(value = "/delete/{id}")
    public DataResponse<Object> deleteUser(@PathVariable Long id) {
        DataResponse<Object> dataResponse = new DataResponse<>();
        try {
            userService.deleteUser(id);
            dataResponse.setResponse(Response.getSuccessResponse());
        } catch (Exception e) {
            dataResponse.setResponse(Response.getInternalServerErrorResponse(e.getMessage()));
        }
        return dataResponse;
    }

    @GetMapping(value = "/getAll")
    public ListResponse<User> getAllUser() {
        ListResponse<User> listResponse = new ListResponse<>();
        listResponse.setData(userService.getAllUser());
        listResponse.setStatus(Response.getSuccessResponse());

        return listResponse;
    }
}
