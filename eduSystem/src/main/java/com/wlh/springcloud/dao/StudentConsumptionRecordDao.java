package com.wlh.springcloud.dao;

import com.wlh.springcloud.entity.StudentConsumptionRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentConsumptionRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentConsumptionRecord record);

    int insertSelective(StudentConsumptionRecord record);

    StudentConsumptionRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentConsumptionRecord record);

    int updateByPrimaryKey(StudentConsumptionRecord record);

    List<StudentConsumptionRecord> selectByStudentId(Integer studentId);

    List<StudentConsumptionRecord> getAllConsumption();
}
