package com.example.registration.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="ENROLLMENT",
       uniqueConstraints = @UniqueConstraint(columnNames = {"STUDENT_ID","COURSE_ID"}))
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enroll_gen")
    @SequenceGenerator(name="enroll_gen", sequenceName="ENROLL_SEQ", allocationSize=1)
    private Long id;
    

    @ManyToOne
    @JoinColumn(name="STUDENT_ID")
    private Student student;

    @ManyToOne
    @JoinColumn(name="COURSE_ID")
    private Course course;
    
    private String status; // PENDING, APPROVED
    
    

    private LocalDate enrollmentDate;

    public Enrollment() {}

    public Long getId() { return id; }
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }

    public void setId(Long id) { this.id = id; }
    public void setStudent(Student student) { this.student = student; }
    public void setCourse(Course course) { this.course = course; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
