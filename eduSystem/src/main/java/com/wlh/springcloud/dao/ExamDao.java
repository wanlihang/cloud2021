package com.wlh.springcloud.dao;

import com.wlh.springcloud.entity.Exam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);
}
