package com.example.registration.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registration.entity.*;
import com.example.registration.repository.*;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseRepository courseRepo;

    // 👨‍🎓 STUDENT → REQUEST
    public String requestEnrollment(Long studentId, Long courseId) {

        if (enrollRepo.findByStudentIdAndCourseId(studentId, courseId).isPresent()) {
            return "Already requested";
        }

        Student s = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course c = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment e = new Enrollment();
        e.setStudent(s);
        e.setCourse(c);
        e.setEnrollmentDate(LocalDate.now());
        e.setStatus("PENDING");

        enrollRepo.save(e);

        return "Request Sent";
    }

    // 👨‍💼 ADMIN → APPROVE
    public String approveEnrollment(Long id) {

        Enrollment e = enrollRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));

        e.setStatus("APPROVED");
        enrollRepo.save(e);

        return "Approved";
    }

    // GET ALL
    public List<Enrollment> getAllEnrollments() {
        return enrollRepo.findAll();
    }

    // 🔥 IMPORTANT: For student dashboard
    public List<Enrollment> getEnrollmentsByStudent(Long studentId) {
        return enrollRepo.findByStudentId(studentId);
    }

    // DELETE
    public void deleteEnrollment(Long id) {
        enrollRepo.deleteById(id);
    }
}