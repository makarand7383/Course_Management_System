package com.example.registration.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;  

@Entity
@Table(name="STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
    @SequenceGenerator(name="student_gen", sequenceName="STUDENT_SEQ", allocationSize=1)
    private Long id;

    // VALIDATION
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    public Student() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}