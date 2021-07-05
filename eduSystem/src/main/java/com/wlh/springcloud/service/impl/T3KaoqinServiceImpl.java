package com.wlh.springcloud.service.impl;


import com.wlh.springcloud.dao.T3KaoqinDao;
import com.wlh.springcloud.entities.T3Kaoqin;
import com.wlh.springcloud.service.T3KaoqinService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class T3KaoqinServiceImpl implements T3KaoqinService {
    @Resource
    private T3KaoqinDao kaoqinDao;

    @Override
    public List<T3Kaoqin> getAllChengjiFromClaIds(List<Integer> claIds) {
        List<T3Kaoqin> kaoqinList = kaoqinDao.getAllChengjiFromClaIds(claIds);
        return kaoqinList;
    }

    @Override
    public List<T3Kaoqin> selectByStudentId(Integer studentId){
        List<T3Kaoqin> kaoqinList = kaoqinDao.selectByStudentId(studentId);
        return kaoqinList;
    }

    @Override
    public List<T3Kaoqin> selectByClaId(Integer claId) {
        List<T3Kaoqin> kaoqinList = kaoqinDao.selectByClaId(claId);
        return kaoqinList;
    }

    @Override
    public List<T3Kaoqin> getAllKaoqin() {
        List<T3Kaoqin> kaoqinList = kaoqinDao.getAllKaoqin();
        return kaoqinList;
    }
}
