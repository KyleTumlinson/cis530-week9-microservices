package edu.bellevue.cis530.student_profile_service.service.impl;

import edu.bellevue.cis530.student_profile_service.entity.StudentProfile;
import edu.bellevue.cis530.student_profile_service.repository.StudentProfileRepository;
import edu.bellevue.cis530.student_profile_service.service.StudentProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;
    @Override
    public StudentProfile createProfile(StudentProfile profile) {
        return studentProfileRepository.save(profile);
    }

    @Override
    public List<StudentProfile> getAllProfiles() {
        return studentProfileRepository.findAll();
    }

    @Override
    public StudentProfile getProfileById(Long id) {
        return studentProfileRepository.findById(id).get();
    }

    @Override
    public StudentProfile getProfileByStudentId(Long studentId) {
        return studentProfileRepository.findProfileByStudentId(studentId);
    }

    @Override
    public void deleteProfileById(Long id) {
        studentProfileRepository.deleteById(id);
    }
}
