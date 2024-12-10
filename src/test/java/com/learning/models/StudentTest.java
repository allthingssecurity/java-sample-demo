package com.learning.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student student;
    private Course course;
    private Instructor instructor;
    private Assessment assessment;

    @BeforeEach
    void setUp() {
        student = new Student("Test Student", "test@test.com");
        instructor = new Instructor("Test Instructor", "instructor@test.com", "Test Department");
        course = new Course("Test Course", "Test Description", instructor);
        assessment = new Assessment("Test Quiz", "Test Quiz Description", AssessmentType.QUIZ);
    }

    @Test
    void testStudentCreation() {
        assertNotNull(student.getId());
        assertEquals("Test Student", student.getName());
        assertEquals("test@test.com", student.getEmail());
        assertTrue(student.getEnrolledCourses().isEmpty());
        assertTrue(student.getCompletedAssessments().isEmpty());
    }

    @Test
    void testCourseEnrollment() {
        student.enrollInCourse(course);
        assertEquals(1, student.getEnrolledCourses().size());
        assertTrue(student.getEnrolledCourses().contains(course));
    }

    @Test
    void testDuplicateCourseEnrollment() {
        student.enrollInCourse(course);
        student.enrollInCourse(course);
        assertEquals(1, student.getEnrolledCourses().size());
    }

    @Test
    void testAssessmentCompletion() {
        student.completeAssessment(assessment, 85.5);
        assertEquals(1, student.getCompletedAssessments().size());
        assertEquals(85.5, student.getCompletedAssessments().get(0).getScore());
    }

    @Test
    void testAverageScore() {
        student.completeAssessment(new Assessment("Quiz 1", "Description", AssessmentType.QUIZ), 90.0);
        student.completeAssessment(new Assessment("Quiz 2", "Description", AssessmentType.QUIZ), 80.0);
        assertEquals(85.0, student.getAverageScore());
    }

    @Test
    void testAverageScoreWithNoAssessments() {
        assertEquals(0.0, student.getAverageScore());
    }
}
