package com.wlh.springcloud.dao;

import com.wlh.springcloud.entities.T1Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface T1TeacherDao {
    int deleteByPrimaryKey(Integer id);

    int insert(T1Teacher record);

    int insertSelective(T1Teacher record);

    T1Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T1Teacher record);

    int updateByPrimaryKey(T1Teacher record);
}