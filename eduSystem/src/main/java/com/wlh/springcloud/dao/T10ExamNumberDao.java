package com.wlh.springcloud.dao;

import com.wlh.springcloud.entities.T10ExamNumber;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface T10ExamNumberDao {

    int deleteByPrimaryKey(Integer id);

    int insert(T10ExamNumber record);

    int insertSelective(T10ExamNumber record);

    T10ExamNumber selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T10ExamNumber record);

    int updateByPrimaryKey(T10ExamNumber record);
}