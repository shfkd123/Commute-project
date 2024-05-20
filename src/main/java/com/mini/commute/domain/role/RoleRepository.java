package com.mini.commute.domain.role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Object> findByRoleCode(String roleCode);
}
