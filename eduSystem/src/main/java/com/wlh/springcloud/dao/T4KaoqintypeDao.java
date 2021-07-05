package com.wlh.springcloud.dao;

import com.wlh.springcloud.entities.T4Kaoqintype;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface T4KaoqintypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(T4Kaoqintype record);

    int insertSelective(T4Kaoqintype record);

    T4Kaoqintype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T4Kaoqintype record);

    int updateByPrimaryKey(T4Kaoqintype record);
}