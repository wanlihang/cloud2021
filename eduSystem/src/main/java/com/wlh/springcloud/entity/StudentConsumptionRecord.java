package com.wlh.springcloud.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * student_consumption_record
 * @author 
 */
@Data
public class StudentConsumptionRecord implements Serializable {
    private Integer id;

    private String consumptionTime;

    private Integer amount;

    private Integer studentId;

    private static final long serialVersionUID = 1L;
}