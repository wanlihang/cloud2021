package com.wlh.springcloud.entities;

import java.io.Serializable;
import lombok.Data;

/**
 * t8_class_id
 * @author 
 */
@Data
public class T8ClassId implements Serializable {
    private Integer id;

    private Integer claId;

    private String claName;

    private Integer claNum;

    private static final long serialVersionUID = 1L;
}