package com.wlh.springcloud.service;


import com.wlh.springcloud.entity.Student;

import java.util.List;

public interface StudentService {

    Student selectByBfStudentId(Integer BfStudentId);

    List<Student> selectByClaId(Integer claId);

    List<Student> getAllStudent();

}
