package com.wlh.springcloud.service.impl;

import com.wlh.springcloud.dao.StudentConsumptionRecordDao;
import com.wlh.springcloud.entity.StudentConsumptionRecord;
import com.wlh.springcloud.service.StudentConsumptionRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentConsumptionRecordServiceImpl implements StudentConsumptionRecordService {
    @Resource
    private StudentConsumptionRecordDao consumptionDao;

    @Override
    public List<StudentConsumptionRecord> selectByStudentId(Integer studentId){
        List<StudentConsumptionRecord> consumptionList = consumptionDao.selectByStudentId(studentId);
        return consumptionList;
    }

    @Override
    public List<StudentConsumptionRecord> getAllConsumption() {
        List<StudentConsumptionRecord> consumptionList = consumptionDao.getAllConsumption();
        return consumptionList;
    }


}
