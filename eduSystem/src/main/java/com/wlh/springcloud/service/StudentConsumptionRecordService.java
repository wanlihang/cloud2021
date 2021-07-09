package com.wlh.springcloud.service;


import com.wlh.springcloud.entity.StudentConsumptionRecord;

import java.util.List;

public interface StudentConsumptionRecordService {

    List<StudentConsumptionRecord> selectByStudentId(Integer studentId);

    List<StudentConsumptionRecord> getAllConsumption();

}
