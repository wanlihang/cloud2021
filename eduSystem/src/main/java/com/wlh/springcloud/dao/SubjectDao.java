package com.wlh.springcloud.dao;

import com.wlh.springcloud.entity.Subject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubjectDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);
}
