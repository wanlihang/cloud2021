package com.wlh.springcloud.service;


import com.wlh.springcloud.entities.T7Consumption;

import java.util.List;

public interface T7ConsumptionService {

    List<T7Consumption> selectByStudentId(Integer studentId);

    List<T7Consumption> getAllConsumption();

}
