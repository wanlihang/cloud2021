package com.wlh.springcloud.entities;

import java.io.Serializable;
import lombok.Data;

/**
 * t1_teacher
 * @author 
 */
@Data
public class T1Teacher implements Serializable {
    private Integer id;

    private String term;

    private Integer claId;

    private String claName;

    private Integer graId;

    private String graName;

    private Integer subId;

    private String subName;

    private Integer basId;

    private String basName;

    private static final long serialVersionUID = 1L;
}