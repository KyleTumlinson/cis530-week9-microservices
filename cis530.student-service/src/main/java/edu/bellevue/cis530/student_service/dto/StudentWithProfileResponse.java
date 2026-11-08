package edu.bellevue.cis530.student_service.dto;

import edu.bellevue.cis530.student_service.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentWithProfileResponse {
    private Student student;
    private StudentProfileDto profile;
}
