package com.wlh.springcloud.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * exam
 * @author 
 */
@Data
public class Exam implements Serializable {
    private Integer id;

    private Integer examId;

    private String examName;

    private static final long serialVersionUID = 1L;
}