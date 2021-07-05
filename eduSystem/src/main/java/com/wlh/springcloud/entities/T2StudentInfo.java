package com.wlh.springcloud.entities;

import java.io.Serializable;
import lombok.Data;

/**
 * t2_student_info
 * @author 
 */
@Data
public class T2StudentInfo implements Serializable {
    private Integer id;

    private Integer bfStudentid;

    private String bfName;

    private String bfSex;

    private String bfNation;

    private String bfBorndate;

    private String claName;

    private String bfNativeplace;

    private String bfResidencetype;

    private String bfPolicy;

    private Integer claId;

    private String claTerm;

    private Integer bfZhusu;

    private Integer bfLeaveschool;

    private Integer bfQinshihao;

    private Integer graId;

    private String graName;

    private static final long serialVersionUID = 1L;
}