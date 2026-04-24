package com.example.registration.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.registration.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByNameContainingIgnoreCase(String name);
}