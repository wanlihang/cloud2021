package com.wlh.springcloud.entities;

import java.io.Serializable;
import lombok.Data;

/**
 * t5_chengji
 * @author 
 */
@Data
public class T5Chengji implements Serializable {
    private Integer id;

    private Integer mesTestid;

    private Integer examNumber;

    private String examNumname;

    private Integer mesSubId;

    private String mesSubName;

    private String examTerm;

    private Integer examType;

    private String examSdate;

    private Integer mesStudentid;

    private Integer mesScore;

    private String mesZScore;

    private String mesTScore;

    private String mesDengdi;

    private Integer claId;

    private static final long serialVersionUID = 1L;
}