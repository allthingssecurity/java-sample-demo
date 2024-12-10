package com.learning.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Student {
    private String id;
    private String name;
    private String email;
    private List<Course> enrolledCourses;
    private List<Assessment> completedAssessments;

    public Student(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.enrolledCourses = new ArrayList<>();
        this.completedAssessments = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);
        }
    }

    public void completeAssessment(Assessment assessment, double score) {
        assessment.setScore(score);
        completedAssessments.add(assessment);
    }

    public double getAverageScore() {
        if (completedAssessments.isEmpty()) return 0.0;
        return completedAssessments.stream()
                .mapToDouble(Assessment::getScore)
                .average()
                .orElse(0.0);
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Course> getEnrolledCourses() { return new ArrayList<>(enrolledCourses); }
    public List<Assessment> getCompletedAssessments() { return new ArrayList<>(completedAssessments); }
}
