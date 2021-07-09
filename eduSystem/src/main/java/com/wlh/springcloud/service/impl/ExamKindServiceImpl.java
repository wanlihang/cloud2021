package com.wlh.springcloud.service.impl;

import com.wlh.springcloud.dao.ExamKindDao;
import com.wlh.springcloud.entity.ExamKind;
import com.wlh.springcloud.service.ExamKindService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamKindServiceImpl implements ExamKindService {
    @Resource
    private ExamKindDao examKindDao;

    @Override
    public List<ExamKind> getAllExamKind() {
        List<ExamKind> examTypes = examKindDao.getAllExamKind();
        return examTypes;
    }
}
