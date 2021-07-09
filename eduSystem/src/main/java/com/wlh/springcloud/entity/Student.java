package com.wlh.springcloud.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private Integer id;

    private Integer studentId;

    private String studentName;

    private String gender;

    private String nation;

    private String birthYear;

    private String nativePlace;

    private String residenceType;

    private String policy;

    private Integer gradeId;

    private Integer classId;

    private Integer qinshihao;

    private Integer isZhusu;

    private Integer isLeaveSchool;

    private static final long serialVersionUID = 1L;
}