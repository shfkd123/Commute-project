package com.mini.commute.domain.role;

import com.mini.commute.domain.employee.Employee;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 50, name ="role_code", unique=true)
    private String roleCode;

    @Column(nullable = false, length = 50, name ="name")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<Employee> employees = new ArrayList<Employee>();


    protected Role() {

    }

    public Role(String roleCode, String name) throws IllegalAccessException {
        if(roleCode == null || roleCode.isBlank() && name == null || name.isBlank()){
            throw new IllegalAccessException(String.format("잘못된 name(%s), roleCode(%s)이 들어왔습니다.", name, roleCode));
        }
        this.roleCode = roleCode;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
