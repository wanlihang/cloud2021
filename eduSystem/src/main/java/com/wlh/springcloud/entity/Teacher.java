package com.wlh.springcloud.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * teacher
 * @author 
 */
@Data
public class Teacher implements Serializable {
    private Integer id;

    private Integer teacherId;

    private String teacherName;

    private Integer subjectId;

    private Integer gradeId;

    private Integer classId;

    private static final long serialVersionUID = 1L;
}