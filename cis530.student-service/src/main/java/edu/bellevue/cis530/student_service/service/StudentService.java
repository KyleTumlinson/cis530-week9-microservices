package edu.bellevue.cis530.student_service.service;

import edu.bellevue.cis530.student_service.dto.StudentWithProfileResponse;
import edu.bellevue.cis530.student_service.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentByID(Long id);
    StudentWithProfileResponse getStudentWithProfile(Long id);
    void deleteStudentByID(Long id);
}
