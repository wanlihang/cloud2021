package com.wlh.springcloud.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * class
 * @author
 */
@Data
public class Class implements Serializable {
    private Integer id;

    private Integer gradeId;

    private String gradeName;

    private Integer classId;

    private String className;

    private Integer studentNumber;

    private static final long serialVersionUID = 1L;
}
