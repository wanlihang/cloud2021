package com.wlh.springcloud.service.impl;


import com.wlh.springcloud.dao.StudentDao;
import com.wlh.springcloud.entity.Student;
import com.wlh.springcloud.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student selectByBfStudentId(Integer studentId){
        Student studentInfo = studentDao.selectByStudentId(studentId);
        return studentInfo;
    }

    @Override
    public List<Student> selectByClaId(Integer claId){
        List<Student> studentInfoList = studentDao.selectByClaId(claId);
        return studentInfoList;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = studentDao.getAllStudent();
        return studentList;
    }

}
