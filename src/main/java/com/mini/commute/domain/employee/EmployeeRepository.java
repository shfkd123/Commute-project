package com.mini.commute.domain.employee;

import com.mini.commute.dto.employee.response.EmployeeListInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT " +
            "e.name, " +
            "t.name as teamName, " +
            "r.name as role, " +
            "e.birthday, " +
            "e.work_start_date as workStartDate " +
            "from employee e " +
            "left join team t on t.id = e.team_id " +
            "left join role r on r.id = e.role_id ",
            nativeQuery = true)
    List<EmployeeListInterface> findAllTeam();
}
