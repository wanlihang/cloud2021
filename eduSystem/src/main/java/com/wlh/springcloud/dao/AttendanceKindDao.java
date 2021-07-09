package com.wlh.springcloud.dao;

import com.wlh.springcloud.entity.AttendanceKind;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttendanceKindDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AttendanceKind record);

    int insertSelective(AttendanceKind record);

    AttendanceKind selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AttendanceKind record);

    int updateByPrimaryKey(AttendanceKind record);
}
