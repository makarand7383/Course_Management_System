package com.example.registration.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.registration.entity.Course;
import com.example.registration.service.CourseService;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course addCourse(@RequestBody Course c) {
        return courseService.addCourse(c);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id,
                               @RequestBody Course c) {
        return courseService.updateCourse(id, c);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Course deleted successfully";
    }

    @GetMapping("/search/{title}")
    public List<Course> searchCourse(@PathVariable String title) {
        return courseService.searchCourse(title);
    }
}