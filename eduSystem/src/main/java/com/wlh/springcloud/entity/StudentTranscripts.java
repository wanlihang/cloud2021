package com.wlh.springcloud.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * student_transcripts
 * @author 
 */
@Data
public class StudentTranscripts implements Serializable {
    private Integer id;

    private Integer studentId;

    private Integer classId;

    private String examTerm;

    private Integer testId;

    private Integer subjectId;

    private Integer examId;

    private Integer examKindId;

    private String examDate;

    private Integer score;

    private String zScore;

    private String tScore;

    private String dengdi;

    private static final long serialVersionUID = 1L;
}