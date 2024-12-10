package com.learning.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Instructor {
    private String id;
    private String name;
    private String email;
    private String department;
    private List<Course> courses;

    public Instructor(String name, String email, String department) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.department = department;
        this.courses = new ArrayList<>();
    }

    public Course createCourse(String name, String description) {
        Course course = new Course(name, description, this);
        courses.add(course);
        return course;
    }

    public Assessment createAssessment(Course course, String title, String description, AssessmentType type) {
        Assessment assessment = new Assessment(title, description, type);
        course.addAssessment(assessment);
        return assessment;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
    public List<Course> getCourses() { return new ArrayList<>(courses); }
}
