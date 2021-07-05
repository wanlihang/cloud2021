package com.wlh.springcloud.dao;

import com.wlh.springcloud.entities.T8ClassId;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface T8ClassIdDao {
    int deleteByPrimaryKey(Integer id);

    int insert(T8ClassId record);

    int insertSelective(T8ClassId record);

    T8ClassId selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T8ClassId record);

    int updateByPrimaryKey(T8ClassId record);
}