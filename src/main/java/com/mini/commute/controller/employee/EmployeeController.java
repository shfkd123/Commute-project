package com.mini.commute.controller.employee;

import com.mini.commute.dto.employee.request.EmployeeCreateRequest;
import com.mini.commute.dto.employee.response.EmployeeListInterface;
import com.mini.commute.service.employee.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee/save")
    public void saveEmployee(@RequestBody EmployeeCreateRequest request) throws IllegalAccessException {
        employeeService.saveEmployee(request);
    }

    @GetMapping("/employee")
    public List<EmployeeListInterface> getEmployeeList() {
        return employeeService.getEmployeeList();
    }
}
