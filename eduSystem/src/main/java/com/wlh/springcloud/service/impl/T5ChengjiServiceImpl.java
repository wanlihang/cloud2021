package com.wlh.springcloud.service.impl;


import com.wlh.springcloud.dao.T5ChengjiDao;
import com.wlh.springcloud.entities.T5Chengji;
import com.wlh.springcloud.service.T5ChengjiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class T5ChengjiServiceImpl implements T5ChengjiService {
    @Resource
    private T5ChengjiDao chengjiDao;


    @Override
    public List<T5Chengji> getAllChengjiFromClaIds(List<Integer> claIds) {//查找所有给出班级的成绩信息，班级升序
        List<T5Chengji> chengjiList = chengjiDao.getAllChengjiFromClaIds(claIds);
        return chengjiList;
    }

    @Override
    public List<T5Chengji> getAllChengji() {
        List<T5Chengji> chengjiList = chengjiDao.getAllChengji();
        return chengjiList;
    }

    @Override
    public List<T5Chengji> selectByStudentId(Integer studentId){
        List<T5Chengji> chengjiList = chengjiDao.selectByStudentId(studentId);
        return chengjiList;
    }

    @Override
    public List<T5Chengji> selectByClaId(Integer claId) {
        List<T5Chengji> chengjiList = chengjiDao.selectByClaId(claId);
        return chengjiList;
    }

    @Override
    public List<T5Chengji> selectByExamType(Integer examType){
        List<T5Chengji> chengjiList = chengjiDao.selectByExamType(examType);
        return chengjiList;
    }

    @Override
    public List<T5Chengji> selectByExamNumber(Integer examNumber){
        List<T5Chengji> chengjiList = chengjiDao.selectByExamNumber(examNumber);
        return chengjiList;
    }

    @Override
    public List<T5Chengji> selectByMesSubId(Integer mesSubId){
        List<T5Chengji> chengjiList = chengjiDao.selectByMesSubId(mesSubId);
        return chengjiList;
    }

    @Override
    public List<T5Chengji> selectByExamNumberAndStuId(int examNumber, int stuId) {
        List<T5Chengji> chengjiList = chengjiDao.selectByExamNumberAndStuId(examNumber, stuId);
        return chengjiList;
    }

    @Override
    public int getAvgScore(Integer testId) {
        if(testId.equals(0)){
            return 0;
        }
        int avgScore = 0;
        int count = 0;

        List<T5Chengji> chengjiList = chengjiDao.selectByTestId(testId);

        //得到成绩并相加
        for(T5Chengji chengji : chengjiList){
            if(chengji.getMesScore() > 0){
                avgScore += chengji.getMesScore();
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

        List<T5Chengji> chengjiList = chengjiDao.selectByTestId(testId);//得到当前考试当前科目的成绩
        for(T5Chengji chengji : chengjiList){
            if(chengji.getMesScore() > maxScore){
                maxScore = chengji.getMesScore();
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

        List<T5Chengji> chengjiList = chengjiDao.getScoreFromStuList(studentIdList, subId, 304);//得到当前考试当前科目的成绩，默认ExamNumber为304

        //得到成绩并相加
        for(T5Chengji chengji : chengjiList){
            if(chengji.getMesScore() > 0){
                avgScore += chengji.getMesScore();
                count++;
            }
        }
        if(count > 0){
            avgScore /= count;
        }
        return avgScore;
    }



}
