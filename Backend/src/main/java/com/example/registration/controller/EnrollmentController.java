package com.example.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.registration.entity.Enrollment;
import com.example.registration.service.EnrollmentService;

@RestController
@RequestMapping("/api/enrollment")
@CrossOrigin(origins = "http://localhost:3000")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // 👨‍🎓 STUDENT → REQUEST
    @PostMapping("/request/{studentId}/{courseId}")
    public String requestEnrollment(@PathVariable Long studentId,
                                    @PathVariable Long courseId) {
        return enrollmentService.requestEnrollment(studentId, courseId);
    }

    // 👨‍💼 ADMIN → APPROVE
    @PutMapping("/approve/{id}")
    public String approveEnrollment(@PathVariable Long id) {
        return enrollmentService.approveEnrollment(id);
    }

    // GET ALL (ADMIN)
    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    // 🔥 IMPORTANT (STUDENT DASHBOARD)
    @GetMapping("/student/{id}")
    public List<Enrollment> getStudentEnrollments(@PathVariable Long id) {
        return enrollmentService.getEnrollmentsByStudent(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return "Deleted";
    }
}