package com.wlh.springcloud.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * subject
 * @author 
 */
@Data
public class Subject implements Serializable {
    private Integer id;

    private Integer subjectId;

    private String subjectName;

    private static final long serialVersionUID = 1L;
}