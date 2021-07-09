package com.wlh.springcloud.service.impl;


import com.wlh.springcloud.dao.AttendanceDao;
import com.wlh.springcloud.entity.Attendance;
import com.wlh.springcloud.service.AttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Resource
    private AttendanceDao attendanceDao;

    @Override
    public List<Attendance> selectByStudentId(Integer studentId){
        List<Attendance> kaoqinList = attendanceDao.selectByStudentId(studentId);
        return kaoqinList;
    }
}
