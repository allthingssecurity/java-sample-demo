package com.learning.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Course {
    private String id;
    private String name;
    private String description;
    private Instructor instructor;
    private List<Student> enrolledStudents;
    private List<Assessment> assessments;

    public Course(String name, String description, Instructor instructor) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.instructor = instructor;
        this.enrolledStudents = new ArrayList<>();
        this.assessments = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public void addAssessment(Assessment assessment) {
        assessments.add(assessment);
    }

    public double getCourseAverageScore() {
        if (enrolledStudents.isEmpty()) return 0.0;
        return enrolledStudents.stream()
                .mapToDouble(Student::getAverageScore)
                .average()
                .orElse(0.0);
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Instructor getInstructor() { return instructor; }
    public List<Student> getEnrolledStudents() { return new ArrayList<>(enrolledStudents); }
    public List<Assessment> getAssessments() { return new ArrayList<>(assessments); }
}
