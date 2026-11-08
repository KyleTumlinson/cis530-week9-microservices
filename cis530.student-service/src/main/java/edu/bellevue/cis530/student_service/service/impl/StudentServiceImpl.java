package edu.bellevue.cis530.student_service.service.impl;

import edu.bellevue.cis530.student_service.client.StudentProfileClient;
import edu.bellevue.cis530.student_service.dto.StudentProfileDto;
import edu.bellevue.cis530.student_service.dto.StudentWithProfileResponse;
import edu.bellevue.cis530.student_service.entity.Student;
import edu.bellevue.cis530.student_service.repository.StudentRepository;
import edu.bellevue.cis530.student_service.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentProfileClient studentProfileClient;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByID(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public StudentWithProfileResponse getStudentWithProfile(Long id) {
        // get the student
        Student foundStudent = getStudentByID(id);
        // get the profileDTO
        StudentProfileDto newProfile = studentProfileClient.getProfileByStudentId(foundStudent.getId());
        // add the student information to the Response
        return new StudentWithProfileResponse(foundStudent, newProfile);
    }

    @Override
    public void deleteStudentByID(Long id) {
        studentRepository.deleteById(id);
    }
}
