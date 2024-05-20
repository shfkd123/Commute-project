package com.mini.commute.domain.employee;

import com.mini.commute.domain.role.Role;
import com.mini.commute.domain.team.Team;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(nullable = false, length = 30, name ="name")
    private String name;

    @Column
    private LocalDate workStartDate;

    @Column
    private LocalDate birthday;

    protected Employee() {

    }

    public Employee(Team team, Role role, String name, LocalDate workStartDate, LocalDate birthday) {
        this.team = team;
        this.role = role;
        this.name = name;
        this.workStartDate = workStartDate;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public Team getTeam() {
        return team;
    }

    public Role getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWorkStartDate() {
        return workStartDate;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
