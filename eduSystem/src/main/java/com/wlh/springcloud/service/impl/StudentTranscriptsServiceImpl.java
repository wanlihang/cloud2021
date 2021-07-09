package com.wlh.springcloud.service.impl;


import com.wlh.springcloud.dao.StudentTranscriptsDao;
import com.wlh.springcloud.entity.StudentTranscripts;
import com.wlh.springcloud.service.StudentTranscriptsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentTranscriptsServiceImpl implements StudentTranscriptsService {
    @Resource
    private StudentTranscriptsDao studentTranscriptsDao;

    @Override
    public List<StudentTranscripts> getAllChengjiFromClaIds(List<Integer> claIds) {
        return null;
    }

    @Override
    public List<StudentTranscripts> getAllChengji() {
        return null;
    }

    @Override
    public List<StudentTranscripts> selectByStudentId(Integer studentId){
        List<StudentTranscripts> studentTranscriptsList = studentTranscriptsDao.selectByStudentId(studentId);
        return studentTranscriptsList;
    }

    @Override
    public List<StudentTranscripts> selectByClaId(Integer claId) {
        List<StudentTranscripts> studentTranscriptsList = studentTranscriptsDao.selectByClaId(claId);
        return studentTranscriptsList;
    }

    @Override
    public List<StudentTranscripts> selectByExamType(Integer examType){
        List<StudentTranscripts> studentTranscriptsList = studentTranscriptsDao.selectByExamKindId(examType);
        return studentTranscriptsList;
    }

    @Override
    public List<StudentTranscripts> selectByExamNumber(Integer examNumber){
        List<StudentTranscripts> studentTranscriptsList = studentTranscriptsDao.selectByExamKindId(examNumber);
        return studentTranscriptsList;
    }

    @Override
    public List<StudentTranscripts> selectByMesSubId(Integer mesSubId){
        List<StudentTranscripts> studentTranscriptsList = studentTranscriptsDao.selectBySubjectId(mesSubId);
        return studentTranscriptsList;
    }

    @Override
    public List<StudentTranscripts> selectByExamNumberAndStuId(int examNumber, int stuId) {
        List<StudentTranscripts> studentTranscriptsList = studentTranscriptsDao.selectByExamIdAndStuId(examNumber, stuId);
        return studentTranscriptsList;
    }

    @Override
    public int getAvgScore(Integer testId) {
        if(testId.equals(0)){
            return 0;
        }
        int avgScore = 0;
        int count = 0;

        List<StudentTranscripts> studentTranscriptsList = studentTranscriptsDao.selectByTestId(testId);

        //得到成绩并相加
        for(StudentTranscripts studentTranscripts : studentTranscriptsList){
            if(studentTranscripts.getScore() > 0){
                avgScore += studentTranscripts.getScore();
                count++;
            }
        }
        if(count > 0){
            avgScore /= count;
        }

        return avgScore;
    }

    @Override
    public int getMaxScore(Integer testId) {
        int maxScore = 0;

        List<StudentTranscripts> studentTranscriptsList = studentTranscriptsDao.selectByTestId(testId);//得到当前考试当前科目的成绩
        for(StudentTranscripts studentTranscripts : studentTranscriptsList){
            if(studentTranscripts.getScore() > maxScore){
                maxScore = studentTranscripts.getScore();
            }
        }
        return maxScore;
    }

    @Override
    public int getAvgScoreByStuList(List<Integer> studentIdList, Integer subId) {
        if(studentIdList.isEmpty()){
            return 0;
        }
        int avgScore = 0;
        int count = 0;

        List<StudentTranscripts> studentTranscriptsList = studentTranscriptsDao.getScoreFromStuList(studentIdList, subId, 304);//得到当前考试当前科目的成绩，默认ExamNumber为304

        //得到成绩并相加
        for(StudentTranscripts studentTranscripts : studentTranscriptsList){
            if(studentTranscripts.getScore() > 0){
                avgScore += studentTranscripts.getScore();
                count++;
            }
        }
        if(count > 0){
            avgScore /= count;
        }
        return avgScore;
    }



}
