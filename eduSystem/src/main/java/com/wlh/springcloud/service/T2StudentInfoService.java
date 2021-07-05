package com.wlh.springcloud.service;


import com.wlh.springcloud.entities.T2StudentInfo;

import java.util.List;

public interface T2StudentInfoService {

    T2StudentInfo selectByBfStudentId(Integer BfStudentId);

    List<T2StudentInfo> selectByClaId(Integer claId);

    List<T2StudentInfo> getAllStudentInfo();

}
