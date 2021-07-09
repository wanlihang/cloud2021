package com.wlh.springcloud.dao;

import com.wlh.springcloud.entity.Attendance;

import java.util.List;

public interface AttendanceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);

    List<Attendance> selectByStudentId(Integer studentId);
}
