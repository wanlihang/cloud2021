package com.wlh.springcloud.dao;

import com.wlh.springcloud.entities.T3Kaoqin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface T3KaoqinDao {
    int deleteByPrimaryKey(Integer id);

    int insert(T3Kaoqin record);

    int insertSelective(T3Kaoqin record);

    T3Kaoqin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T3Kaoqin record);

    int updateByPrimaryKey(T3Kaoqin record);

    List<T3Kaoqin> getAllChengjiFromClaIds(List<Integer> claIds);

    List<T3Kaoqin> selectByStudentId(Integer studentId);

    List<T3Kaoqin> selectByClaId(Integer claId);

    List<T3Kaoqin> getAllKaoqin();
}