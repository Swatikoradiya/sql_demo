package com.example.sqldemo.controller;

import com.example.sqldemo.decorator.DataResponse;
import com.example.sqldemo.decorator.Response;
import com.example.sqldemo.entity.Roles;
import com.example.sqldemo.enums.Role;
import com.example.sqldemo.service.RoleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping(value = "/update/{id}")
    public DataResponse<Roles> updateRoles(@PathVariable Long id, @RequestParam Role role) {
        DataResponse<Roles> dataResponse = new DataResponse<>();
        dataResponse.setData(roleService.updateRoles(id, role));
        dataResponse.setResponse(Response.getSuccessResponse());
        return dataResponse;
    }
}
