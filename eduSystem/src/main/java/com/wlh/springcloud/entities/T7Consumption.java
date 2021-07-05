package com.wlh.springcloud.entities;

import java.io.Serializable;
import lombok.Data;

/**
 * t7_consumption
 * @author 
 */
@Data
public class T7Consumption implements Serializable {
    private Integer id;

    private String dealtime;

    private Integer mondeal;

    private Integer bfStudentid;

    private String accname;

    private String persex;

    private static final long serialVersionUID = 1L;
}