package com.wlh.springcloud.service.impl;


import com.wlh.springcloud.dao.T2StudentInfoDao;
import com.wlh.springcloud.entities.T2StudentInfo;
import com.wlh.springcloud.service.T2StudentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class T2StudentInfoServiceImpl implements T2StudentInfoService {

    @Resource
    private T2StudentInfoDao studentInfoDao;

    @Override
    public T2StudentInfo selectByBfStudentId(Integer studentId){
        T2StudentInfo studentInfo = studentInfoDao.selectByStudentId(studentId);
        return studentInfo;
    }

    @Override
    public List<T2StudentInfo> selectByClaId(Integer claId){
        List<T2StudentInfo> studentInfoList = studentInfoDao.selectByClaId(claId);
        return studentInfoList;
    }

    @Override
    public List<T2StudentInfo> getAllStudentInfo() {
        List<T2StudentInfo> studentInfoList = studentInfoDao.getAllStudentInfo();
        return studentInfoList;
    }

}
