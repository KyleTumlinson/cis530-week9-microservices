package edu.bellevue.cis530.student_service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StudentProfileDto {
    private Long id;
    private Long studentId;
    private String major;
    private BigDecimal gpa;
    private String bio;
}
