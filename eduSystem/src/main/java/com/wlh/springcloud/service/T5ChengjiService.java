package com.wlh.springcloud.service;


import com.wlh.springcloud.entities.T5Chengji;

import java.util.List;

public interface T5ChengjiService {

    List<T5Chengji> getAllChengjiFromClaIds(List<Integer> claIds);

    List<T5Chengji> getAllChengji();

    List<T5Chengji> selectByStudentId(Integer studentId);

    List<T5Chengji> selectByClaId(Integer claId);

    List<T5Chengji> selectByExamType(Integer examType);

    List<T5Chengji> selectByExamNumber(Integer examNumber);

    List<T5Chengji> selectByMesSubId(Integer mesSubId);

    int getAvgScore(Integer testID);

    int getMaxScore(Integer testID);

    int getAvgScoreByStuList(List<Integer> studentIdList, Integer subId);

    List<T5Chengji> selectByExamNumberAndStuId(int examNumber, int stuId);

}
