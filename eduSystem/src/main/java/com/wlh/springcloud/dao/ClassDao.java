package com.wlh.springcloud.dao;

import com.wlh.springcloud.entity.Class;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
}
