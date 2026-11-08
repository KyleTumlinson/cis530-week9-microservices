package edu.bellevue.cis530.student_profile_service.repository;

import edu.bellevue.cis530.student_profile_service.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile,Long> {
    StudentProfile findProfileByStudentId(Long studentId);
}
