package com.wlh.springcloud.service;


import com.wlh.springcloud.entity.Attendance;

import java.util.List;

public interface AttendanceService {
    List<Attendance> selectByStudentId(Integer studentId);

}
