package com.mini.commute.service.role;

import com.mini.commute.domain.role.Role;
import com.mini.commute.domain.role.RoleRepository;
import com.mini.commute.dto.role.RoleCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void saveRole(RoleCreateRequest request) throws IllegalAccessException {
        roleRepository.save(new Role(request.getRoleCode(), request.getName()));
    }
}


