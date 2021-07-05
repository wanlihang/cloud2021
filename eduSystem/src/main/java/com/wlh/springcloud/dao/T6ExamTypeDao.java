package com.wlh.springcloud.dao;

import com.wlh.springcloud.entities.T6ExamType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface T6ExamTypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(T6ExamType record);

    int insertSelective(T6ExamType record);

    T6ExamType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T6ExamType record);

    int updateByPrimaryKey(T6ExamType record);

    List<T6ExamType> getAllExamType();
}