package com.wlh.springcloud.dao;

import com.wlh.springcloud.entity.StudentTranscripts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentTranscriptsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentTranscripts record);

    int insertSelective(StudentTranscripts record);

    StudentTranscripts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentTranscripts record);

    int updateByPrimaryKey(StudentTranscripts record);

    List<StudentTranscripts> getAllChengjiFromClaIds(List<Integer> claIds);

    List<StudentTranscripts> getAllChengji();

    List<StudentTranscripts> selectByStudentId(Integer studentId);

    List<StudentTranscripts> selectByClaId(Integer claId);

    List<StudentTranscripts> selectByExamKindId(Integer examKindId);

    List<StudentTranscripts> selectByExamId(Integer examId);

    List<StudentTranscripts> selectBySubjectId(Integer subjectId);

    List<StudentTranscripts> selectByExamIdAndStuId(Integer examId, Integer stuId);

    List<StudentTranscripts> selectByTestId(Integer testId);

    List<StudentTranscripts> getScoreFromStuList(List<Integer> studentIdList, Integer subId, Integer examNumber);
}
