package com.wlh.springcloud.dao;

import com.wlh.springcloud.entity.ExamKind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ExamKindDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamKind record);

    int insertSelective(ExamKind record);

    ExamKind selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamKind record);

    int updateByPrimaryKey(ExamKind record);

    List<ExamKind> getAllExamKind();
}
