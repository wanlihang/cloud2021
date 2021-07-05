package com.wlh.springcloud.service;


import com.wlh.springcloud.entities.T3Kaoqin;

import java.util.List;

public interface T3KaoqinService {

    List<T3Kaoqin> getAllChengjiFromClaIds(List<Integer> claIds);

    List<T3Kaoqin> selectByStudentId(Integer studentId);

    List<T3Kaoqin> selectByClaId(Integer claId);

    List<T3Kaoqin> getAllKaoqin();


}
