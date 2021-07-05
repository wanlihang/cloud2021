package com.wlh.springcloud.entities;

import java.io.Serializable;
import lombok.Data;

/**
 * t9_subject_id
 * @author 
 */
@Data
public class T9SubjectId implements Serializable {
    private Integer id;

    private Integer subId;

    private String subName;

    private static final long serialVersionUID = 1L;
}