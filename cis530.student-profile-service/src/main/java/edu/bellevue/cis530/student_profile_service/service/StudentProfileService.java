package edu.bellevue.cis530.student_profile_service.service;

import edu.bellevue.cis530.student_profile_service.entity.StudentProfile;

import java.util.List;

public interface StudentProfileService {
    StudentProfile createProfile(StudentProfile profile);
    List<StudentProfile> getAllProfiles();
    StudentProfile getProfileById(Long id);
    StudentProfile getProfileByStudentId(Long studentId);
    void deleteProfileById(Long id);
}
