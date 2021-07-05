package com.wlh.springcloud.entities;

import java.io.Serializable;
import lombok.Data;

/**
 * t10_exam_number
 * @author 
 */
@Data
public class T10ExamNumber implements Serializable {
    private Integer id;

    private Integer examNumber;

    private String examNumname;

    private static final long serialVersionUID = 1L;
}