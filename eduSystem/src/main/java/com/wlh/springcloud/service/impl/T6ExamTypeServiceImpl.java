package com.wlh.springcloud.service.impl;

import com.wlh.springcloud.dao.T6ExamTypeDao;
import com.wlh.springcloud.entities.T6ExamType;
import com.wlh.springcloud.service.T6ExamTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class T6ExamTypeServiceImpl implements T6ExamTypeService {
    @Resource
    private T6ExamTypeDao examTypeDao;

    @Override
    public List<T6ExamType> getAllExamType() {
        List<T6ExamType> examTypes = examTypeDao.getAllExamType();
        return examTypes;
    }
}
