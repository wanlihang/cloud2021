package com.wlh.springcloud.service.impl;

import com.wlh.springcloud.dao.T7ConsumptionDao;
import com.wlh.springcloud.entities.T7Consumption;
import com.wlh.springcloud.service.T7ConsumptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class T7ConsumptionServiceImpl implements T7ConsumptionService {
    @Resource
    private T7ConsumptionDao consumptionDao;

    @Override
    public List<T7Consumption> selectByStudentId(Integer studentId){
        List<T7Consumption> consumptionList = consumptionDao.selectByStudentId(studentId);
        return consumptionList;
    }

    @Override
    public List<T7Consumption> getAllConsumption() {
        List<T7Consumption> consumptionList = consumptionDao.getAllConsumption();
        return consumptionList;
    }


}
