package com.mini.commute.dto.employee.response;

import java.time.LocalDate;

public interface EmployeeListInterface {

    String getName();
    String getTeamName();
    String getRole();
    LocalDate getBirthday();
    LocalDate getWorkStartDate();
}
