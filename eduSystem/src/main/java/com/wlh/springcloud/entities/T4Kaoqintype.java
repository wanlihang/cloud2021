package com.wlh.springcloud.entities;

import java.io.Serializable;
import lombok.Data;

/**
 * t4_kaoqintype
 * @author 
 */
@Data
public class T4Kaoqintype implements Serializable {
    private Integer id;

    private Integer controlerId;

    private String controlerName;

    private Integer controlTaskOrderId;

    private String controlTaskName;

    private static final long serialVersionUID = 1L;
}