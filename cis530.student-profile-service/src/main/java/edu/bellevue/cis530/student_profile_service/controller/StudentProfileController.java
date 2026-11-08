package edu.bellevue.cis530.student_profile_service.controller;

import edu.bellevue.cis530.student_profile_service.entity.StudentProfile;
import edu.bellevue.cis530.student_profile_service.service.StudentProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class StudentProfileController {
    private final StudentProfileService studentProfileService;

    @PostMapping
    public ResponseEntity<StudentProfile> saveProfile(@Valid @RequestBody StudentProfile studentProfile) {
        return new ResponseEntity<>(studentProfileService.createProfile(studentProfile),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAllProfiles() {
        return new ResponseEntity<>(studentProfileService.getAllProfiles(),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentProfile> getProfileById(@PathVariable Long id) {
        return new ResponseEntity<>(studentProfileService.getProfileById(id),
                HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<StudentProfile> getProfileByStudentId(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentProfileService.getProfileByStudentId(studentId),
                HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProfileById(@PathVariable Long id) {
        studentProfileService.deleteProfileById(id);
        return new ResponseEntity<>("Profile with id: " + id + " deleted successfully" ,
                HttpStatus.OK);
    }
}
