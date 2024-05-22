package com.mini.commute.dto.employee.request;

import java.time.LocalDate;

public class EmployeeCreateRequest {

    private String name;

    private Long teamId;

    private String roleCode;

    private LocalDate workStartDate;

    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public Long getTeamId() {
        return teamId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public LocalDate getWorkStartDate() {
        return workStartDate;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
