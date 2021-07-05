package com.wlh.springcloud.service.impl;

import com.wlh.springcloud.dao.T1TeacherDao;
import com.wlh.springcloud.service.T1TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class T1TeacherServiceImpl implements T1TeacherService {
    @Resource
    private T1TeacherDao teacherDao;

}
