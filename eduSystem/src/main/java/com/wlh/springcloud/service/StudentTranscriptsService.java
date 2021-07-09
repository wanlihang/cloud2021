package com.wlh.springcloud.service;


import com.wlh.springcloud.entity.StudentTranscripts;

import java.util.List;

public interface StudentTranscriptsService {

    List<StudentTranscripts> getAllChengjiFromClaIds(List<Integer> claIds);

    List<StudentTranscripts> getAllChengji();

    List<StudentTranscripts> selectByStudentId(Integer studentId);

    List<StudentTranscripts> selectByClaId(Integer claId);

    List<StudentTranscripts> selectByExamType(Integer examType);

    List<StudentTranscripts> selectByExamNumber(Integer examNumber);

    List<StudentTranscripts> selectByMesSubId(Integer mesSubId);

    int getAvgScore(Integer testID);

    int getMaxScore(Integer testID);

    int getAvgScoreByStuList(List<Integer> studentIdList, Integer subId);

    List<StudentTranscripts> selectByExamNumberAndStuId(int examNumber, int stuId);

}
