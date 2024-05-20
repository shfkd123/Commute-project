package com.mini.commute.domain.team;

import com.mini.commute.domain.employee.Employee;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 50, name ="name")
    private String name;


    @OneToMany(mappedBy = "team")
    private List<Employee> employees = new ArrayList<Employee>();

    protected Team() {

    }

    public Team(Long teamId) {
        this.id = teamId;
    }

    public Team(String name) throws IllegalAccessException {
        if(name == null || name.isBlank()){
            throw new IllegalAccessException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
