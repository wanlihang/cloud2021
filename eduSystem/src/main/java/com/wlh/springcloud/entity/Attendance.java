package com.wlh.springcloud.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * attendance
 * @author 
 */
@Data
public class Attendance implements Serializable {
    /**
     * 无意义主键
     */
    private Integer id;

    private String term;

    private Integer attendanceId;

    private String attendanceTime;

    private Integer controllerId;

    private Integer controllerTaskOrderId;

    private Integer studentId;

    private static final long serialVersionUID = 1L;
}