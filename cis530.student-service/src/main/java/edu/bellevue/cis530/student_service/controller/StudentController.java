package edu.bellevue.cis530.student_service.controller;

import edu.bellevue.cis530.student_service.client.StudentProfileClient;
import edu.bellevue.cis530.student_service.dto.StudentWithProfileResponse;
import edu.bellevue.cis530.student_service.entity.Student;
import edu.bellevue.cis530.student_service.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

   @GetMapping
   public ResponseEntity<List<Student>> getAllStudents() {
        return  new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
   }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentByID(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentByID(id), HttpStatus.OK);
    }

    @GetMapping("{id}/full")
    public ResponseEntity<StudentWithProfileResponse> getStudentWithProfile(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentWithProfile(id),  HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentByID(@PathVariable Long id){
        studentService.deleteStudentByID(id);
        return new ResponseEntity<>("Deleted student with Id: " + id ,HttpStatus.OK);
    }
}
