package com.wlh.springcloud.entities;

import java.io.Serializable;
import lombok.Data;

/**
 * t6_exam_type
 * @author 
 */
@Data
public class T6ExamType implements Serializable {
    private Integer id;

    private Integer examKindId;

    private String examKindName;

    private static final long serialVersionUID = 1L;
}