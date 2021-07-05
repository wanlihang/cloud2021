package com.wlh.springcloud.dao;

import com.wlh.springcloud.entities.T9SubjectId;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface T9SubjectIdDao {
    int deleteByPrimaryKey(Integer id);

    int insert(T9SubjectId record);

    int insertSelective(T9SubjectId record);

    T9SubjectId selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T9SubjectId record);

    int updateByPrimaryKey(T9SubjectId record);
}