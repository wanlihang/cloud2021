package com.wlh.springcloud.entities;

import java.io.Serializable;
import lombok.Data;

/**
 * t3_kaoqin
 * @author 
 */
@Data
public class T3Kaoqin implements Serializable {
    /**
     * 无意义主键
     */
    private Integer id;

    private Integer kaoqingId;

    private String qjTerm;

    private String datadatetime;

    private Integer controllerid;

    private String controlerName;

    private Integer controlTaskOrderId;

    private Integer bfStudentid;

    private String bfName;

    private String claName;

    private Integer bfClassid;

    private static final long serialVersionUID = 1L;
}