package com.wlh.springcloud.dao;

import com.wlh.springcloud.entities.T7Consumption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface T7ConsumptionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(T7Consumption record);

    int insertSelective(T7Consumption record);

    T7Consumption selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T7Consumption record);

    int updateByPrimaryKey(T7Consumption record);

    List<T7Consumption> selectByStudentId(Integer studentId);

    List<T7Consumption> getAllConsumption();
}