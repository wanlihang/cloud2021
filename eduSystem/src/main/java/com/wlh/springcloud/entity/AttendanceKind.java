package com.wlh.springcloud.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * attendance_kind
 * @author
 */
@Data
public class AttendanceKind implements Serializable {
    private Integer id;

    private Integer controllerId;

    private String controllerName;

    private Integer controllerTaskOrderId;

    private String controllerTaskName;

    private static final long serialVersionUID = 1L;
}
