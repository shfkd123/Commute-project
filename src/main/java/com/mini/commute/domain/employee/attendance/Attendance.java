package com.mini.commute.domain.employee.attendance;

import com.mini.commute.domain.employee.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "start_work_time")
    private LocalTime startWorkTime;

    @Column(name = "end_work_time")
    private LocalTime endWorkTime;

    protected Attendance() {

    }

    public Attendance(Employee employee, LocalDate date, LocalTime startWorkTime, LocalTime endWorkTime) {
        this.employee = employee;
        this.date = date;
        this.startWorkTime = startWorkTime;
        this.endWorkTime = endWorkTime;
    }

    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartWorkTime() {
        return startWorkTime;
    }

    public LocalTime getEndWorkTime() {
        return endWorkTime;
    }

    public void upDateEndWork(LocalTime time) {
        this.endWorkTime = time;
    }
}