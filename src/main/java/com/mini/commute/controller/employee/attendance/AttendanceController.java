package com.mini.commute.controller.employee.attendance;

import com.mini.commute.dto.employee.attendace.request.AttendanceCreateRequest;
import com.mini.commute.service.employee.attendance.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/goToWork")
    public void saveStartAttendance(@RequestBody AttendanceCreateRequest request) throws IllegalAccessException {
        attendanceService.saveStartAttendance(request);
    }

    @PostMapping("/leaveWork")
    public void saveEndAttendance(@RequestBody AttendanceCreateRequest request) throws IllegalAccessException {
        attendanceService.saveEndAttendance(request);
    }
    @GetMapping("/att/list")
    public Map<String, Object> getAttendanceList(@RequestParam Long employeeId, String date){
        return attendanceService.getAttendanceList(employeeId, date);
    }

}
