package com.learning.services;

import com.learning.models.*;
import java.util.*;

public class LearningManagementSystem {
    private Map<String, Student> students;
    private Map<String, Instructor> instructors;
    private Map<String, Course> courses;

    public LearningManagementSystem() {
        this.students = new HashMap<>();
        this.instructors = new HashMap<>();
        this.courses = new HashMap<>();
    }

    public Student registerStudent(String name, String email) {
        Student student = new Student(name, email);
        students.put(student.getId(), student);
        return student;
    }

    public Instructor registerInstructor(String name, String email, String department) {
        Instructor instructor = new Instructor(name, email, department);
        instructors.put(instructor.getId(), instructor);
        return instructor;
    }

    public Course createCourse(Instructor instructor, String name, String description) {
        Course course = instructor.createCourse(name, description);
        courses.put(course.getId(), course);
        return course;
    }

    public void enrollStudentInCourse(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);
        if (student != null && course != null) {
            student.enrollInCourse(course);
        }
    }

    public List<Course> getAvailableCourses() {
        return new ArrayList<>(courses.values());
    }

    public List<Student> getEnrolledStudents(String courseId) {
        Course course = courses.get(courseId);
        return course != null ? course.getEnrolledStudents() : new ArrayList<>();
    }

    public Map<String, Double> getCourseAverages() {
        Map<String, Double> averages = new HashMap<>();
        courses.values().forEach(course -> 
            averages.put(course.getName(), course.getCourseAverageScore()));
        return averages;
    }
}
