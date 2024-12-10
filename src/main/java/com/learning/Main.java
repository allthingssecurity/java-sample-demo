package com.learning;

import com.learning.models.*;
import com.learning.services.LearningManagementSystem;

public class Main {
    public static void main(String[] args) {
        // Initialize the LMS
        LearningManagementSystem lms = new LearningManagementSystem();

        // Register instructors
        Instructor javaInstructor = lms.registerInstructor("John Doe", "john.doe@university.com", "Computer Science");
        Instructor pythonInstructor = lms.registerInstructor("Jane Smith", "jane.smith@university.com", "Computer Science");

        // Create courses
        Course javaCourse = lms.createCourse(javaInstructor, "Java Programming", "Learn Java fundamentals and OOP concepts");
        Course pythonCourse = lms.createCourse(pythonInstructor, "Python Programming", "Introduction to Python and its applications");

        // Create assessments
        Assessment javaQuiz = javaInstructor.createAssessment(javaCourse, "Java Basics Quiz", "Test your Java fundamentals", AssessmentType.QUIZ);
        Assessment pythonProject = pythonInstructor.createAssessment(pythonCourse, "Python Final Project", "Build a web scraper", AssessmentType.PROJECT);

        // Register and enroll students
        Student student1 = lms.registerStudent("Alice Johnson", "alice@university.com");
        Student student2 = lms.registerStudent("Bob Wilson", "bob@university.com");

        lms.enrollStudentInCourse(student1.getId(), javaCourse.getId());
        lms.enrollStudentInCourse(student1.getId(), pythonCourse.getId());
        lms.enrollStudentInCourse(student2.getId(), javaCourse.getId());

        // Submit assessments
        student1.completeAssessment(javaQuiz, 95.0);
        student2.completeAssessment(javaQuiz, 88.0);
        student1.completeAssessment(pythonProject, 92.0);

        // Print course averages
        System.out.println("\nCourse Averages:");
        lms.getCourseAverages().forEach((courseName, average) -> 
            System.out.printf("%s: %.2f%%\n", courseName, average));

        // Print enrolled students for Java course
        System.out.println("\nStudents enrolled in Java Programming:");
        lms.getEnrolledStudents(javaCourse.getId()).forEach(student -> 
            System.out.printf("%s (%s)\n", student.getName(), student.getEmail()));
    }
}
