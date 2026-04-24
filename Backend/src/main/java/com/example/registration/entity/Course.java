package com.example.registration.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
    @SequenceGenerator(
            name = "course_gen",
            sequenceName = "COURSE_SEQ",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String duration;

    public Course() {
    }

  
    public Course(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

 
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}