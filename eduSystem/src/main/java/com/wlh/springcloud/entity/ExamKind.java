package com.wlh.springcloud.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * exam_kind
 * @author 
 */
@Data
public class ExamKind implements Serializable {
    private Integer id;

    private Integer examKindId;

    private String examKindName;

    private static final long serialVersionUID = 1L;
}