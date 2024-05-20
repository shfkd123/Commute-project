package com.mini.commute.controller.role;

import com.mini.commute.dto.role.RoleCreateRequest;
import com.mini.commute.service.role.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/role/save")
    public void saveRole(@RequestBody RoleCreateRequest request) throws IllegalAccessException {
        roleService.saveRole(request);
    }
}
