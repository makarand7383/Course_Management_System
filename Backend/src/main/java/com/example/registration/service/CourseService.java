package com.example.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registration.entity.Course;
import com.example.registration.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Add Course
    public Course addCourse(Course c) {
        return courseRepository.save(c);
    }

    // Get All Courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get Course By Id
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    // Update Course
    public Course updateCourse(Long id, Course updated) {

        Course c = getCourseById(id);

        c.setTitle(updated.getTitle());
        c.setDuration(updated.getDuration());  

        return courseRepository.save(c);
    }

    // Delete Course
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // Search Course by Title
    public List<Course> searchCourse(String title) {
        return courseRepository.findByTitleContainingIgnoreCase(title);
    }
}