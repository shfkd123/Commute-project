package com.mini.commute.service.employee.attendance;

import com.mini.commute.domain.employee.Employee;
import com.mini.commute.domain.employee.EmployeeRepository;
import com.mini.commute.domain.employee.attendance.Attendance;
import com.mini.commute.domain.employee.attendance.AttendanceRepository;
import com.mini.commute.dto.employee.attendace.request.AttendanceCreateRequest;
import com.mini.commute.dto.employee.attendace.response.AttendanceSumListInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;


    public AttendanceService(AttendanceRepository attendanceRepository, EmployeeRepository employeeRepository) {
        this.attendanceRepository = attendanceRepository;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void saveStartAttendance(AttendanceCreateRequest request) throws IllegalAccessException {
        LocalDate today = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        Long employeeId = request.getEmployeeId();

        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isEmpty()){
            throw new IllegalAccessException("사용자를 찾을 수 없습니다.");
        }

        Optional<Attendance> alreadyTodayAttendance = attendanceRepository.findByEmployeeIdAndDate(employeeId, today);

        if(alreadyTodayAttendance.isPresent()){
            throw new IllegalAccessException("금일"+ today + "\n"+
                    "출근: "+ alreadyTodayAttendance.get().getStartWorkTime() + "\n" +
                    "등록되어 있습니다.");
        }else {
            attendanceRepository.save(new Attendance(employee.get(), today, currentTime, null));
        }
    }

    @Transactional
    public void saveEndAttendance(AttendanceCreateRequest request) throws IllegalAccessException {
        LocalDate today = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        Long employeeId = request.getEmployeeId();

        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isEmpty()){
            throw new IllegalAccessException("사용자를 찾을 수 없습니다.");
        }

        Optional<Attendance> alreadyTodayAttendance = attendanceRepository.findByEmployeeIdAndDate(employeeId, today);

        if(alreadyTodayAttendance.isPresent()){
            if(alreadyTodayAttendance.get().getEndWorkTime() != null){
                throw new IllegalAccessException("금일"+ today + "\n"+
                        "퇴근: "+ alreadyTodayAttendance.get().getStartWorkTime() + "\n" +
                        "등록되어 있습니다.");
            }else{
                alreadyTodayAttendance.get().upDateEndWork(currentTime);
            }
        }else {
            throw new IllegalAccessException("금일 출근 기록이 존재하지 않습니다. \n 인사팀에 문의 바랍니다.");
        }
    }

    @Transactional(readOnly = true)
    public Map<String, Object> getAttendanceList(Long employeeId, String date) {
        List<AttendanceSumListInterface> att = attendanceRepository.attendanceList(employeeId, date);

        int sum = 0;
        for (AttendanceSumListInterface detail : att) {
            sum += Integer.parseInt(detail.getWorkingMinutes());
        }

        Map<String, Object> response = new HashMap<>();
        response.put("detail", att);
        response.put("sum", sum);

        return response;
    }
}
