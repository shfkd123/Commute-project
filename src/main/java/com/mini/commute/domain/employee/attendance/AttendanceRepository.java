package com.mini.commute.domain.employee.attendance;

import com.mini.commute.dto.employee.attendace.response.AttendanceSumListInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findByEmployeeIdAndDate(Long employeeId, LocalDate today);

    @Query(value = "SELECT a.date, " +
            "FLOOR(SUM(CASE " +
            "WHEN TIME_TO_SEC(a.end_Work_Time) < TIME_TO_SEC(a.start_Work_Time) " +
            "THEN TIME_TO_SEC(TIMEDIFF(a.end_Work_Time, a.start_Work_Time)) + 86400 " +
            "ELSE TIME_TO_SEC(TIMEDIFF(a.end_Work_Time, a.start_Work_Time)) " +
            "END) / 60) AS workingMinutes  " +
            "FROM Attendance a " +
            "WHERE a.employee_id = :employeeId " +
            "AND a.date LIKE :date% " +
            "AND a.end_Work_Time is not null " +
            "GROUP BY a.date",
            nativeQuery = true)
    List<AttendanceSumListInterface> attendanceList(@Param("employeeId") Long employeeId, @Param("date") String date);
}
