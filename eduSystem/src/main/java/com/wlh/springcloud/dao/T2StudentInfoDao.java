package com.wlh.springcloud.dao;

import com.wlh.springcloud.entities.T2StudentInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface T2StudentInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(T2StudentInfo record);

    int insertSelective(T2StudentInfo record);

    T2StudentInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T2StudentInfo record);

    int updateByPrimaryKey(T2StudentInfo record);

    T2StudentInfo selectByStudentId(Integer bf_StudentID);

    List<T2StudentInfo> selectByClaId(Integer claId);

    List<T2StudentInfo> getAllStudentInfo();

}