package com.mini.commute.service.employee;

import com.mini.commute.domain.employee.Employee;
import com.mini.commute.domain.employee.EmployeeRepository;
import com.mini.commute.domain.role.Role;
import com.mini.commute.domain.role.RoleRepository;
import com.mini.commute.domain.team.Team;
import com.mini.commute.domain.team.TeamRepository;
import com.mini.commute.dto.employee.EmployeeCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;
    private final RoleRepository roleRepository;

    public EmployeeService(EmployeeRepository employeeRepository, TeamRepository teamRepository, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.teamRepository = teamRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void saveEmployee(EmployeeCreateRequest request) throws IllegalAccessException {

        Team team = teamRepository.findById(request.getTeamId())
                .orElseThrow(() -> new IllegalArgumentException("팀을 찾을 수 없습니다."));

        Role role = (Role) roleRepository.findByRoleCode(request.getRoleCode())
                .orElseThrow(() -> new IllegalArgumentException("직급을 찾을 수 없습니다."));

        employeeRepository.save(new Employee(team, role, request.getName(), request.getWorkStartDate(), request.getBirthday()));
    }

}
