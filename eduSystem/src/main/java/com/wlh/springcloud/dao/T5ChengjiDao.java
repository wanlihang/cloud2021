package com.wlh.springcloud.dao;

import com.wlh.springcloud.entities.T5Chengji;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface T5ChengjiDao {
    int deleteByPrimaryKey(Integer id);

    int insert(T5Chengji record);

    int insertSelective(T5Chengji record);

    T5Chengji selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T5Chengji record);

    int updateByPrimaryKey(T5Chengji record);

    List<T5Chengji> getAllChengjiFromClaIds(List<Integer> claIds);

    List<T5Chengji> getAllChengji();

    List<T5Chengji> selectByStudentId(Integer studentId);

    List<T5Chengji> selectByClaId(Integer claId);

    List<T5Chengji> selectByExamType(Integer examType);

    List<T5Chengji> selectByExamNumber(Integer examNumber);

    List<T5Chengji> selectByMesSubId(Integer mesSubId);

    List<T5Chengji> selectByExamNumberAndStuId(Integer examNumber, Integer stuId);

    List<T5Chengji> selectByTestId(Integer testId);

    List<T5Chengji> getScoreFromStuList(List<Integer> studentIdList, Integer subId, Integer examNumber);
}