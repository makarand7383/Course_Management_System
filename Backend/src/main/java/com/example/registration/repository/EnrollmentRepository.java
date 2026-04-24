package com.example.registration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.registration.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    // Prevent duplicate request
    Optional<Enrollment> findByStudentIdAndCourseId(Long studentId, Long courseId);

    // Get all enrollments of student
    List<Enrollment> findByStudentId(Long studentId);

    // Get all enrollments of course
    List<Enrollment> findByCourseId(Long courseId);
}