package com.learning.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    private Course course;
    private Instructor instructor;
    private Student student;
    private Assessment assessment;

    @BeforeEach
    void setUp() {
        instructor = new Instructor("Test Instructor", "instructor@test.com", "Test Department");
        course = new Course("Test Course", "Test Description", instructor);
        student = new Student("Test Student", "student@test.com");
        assessment = new Assessment("Test Assessment", "Test Description", AssessmentType.QUIZ);
    }

    @Test
    void testCourseCreation() {
        assertNotNull(course.getId());
        assertEquals("Test Course", course.getName());
        assertEquals("Test Description", course.getDescription());
        assertEquals(instructor, course.getInstructor());
        assertTrue(course.getEnrolledStudents().isEmpty());
        assertTrue(course.getAssessments().isEmpty());
    }

    @Test
    void testAddStudent() {
        course.addStudent(student);
        assertEquals(1, course.getEnrolledStudents().size());
        assertTrue(course.getEnrolledStudents().contains(student));
    }

    @Test
    void testAddDuplicateStudent() {
        course.addStudent(student);
        course.addStudent(student);
        assertEquals(1, course.getEnrolledStudents().size());
    }

    @Test
    void testAddAssessment() {
        course.addAssessment(assessment);
        assertEquals(1, course.getAssessments().size());
        assertTrue(course.getAssessments().contains(assessment));
    }

    @Test
    void testCourseAverageScore() {
        Student student1 = new Student("Student 1", "student1@test.com");
        Student student2 = new Student("Student 2", "student2@test.com");
        
        Assessment quiz1 = new Assessment("Quiz 1", "Description", AssessmentType.QUIZ);
        Assessment quiz2 = new Assessment("Quiz 2", "Description", AssessmentType.QUIZ);
        
        student1.completeAssessment(quiz1, 90.0);
        student1.completeAssessment(quiz2, 80.0);
        student2.completeAssessment(quiz1, 70.0);
        student2.completeAssessment(quiz2, 60.0);
        
        course.addStudent(student1);
        course.addStudent(student2);
        
        assertEquals(75.0, course.getCourseAverageScore());
    }

    @Test
    void testCourseAverageScoreWithNoStudents() {
        assertEquals(0.0, course.getCourseAverageScore());
    }
}
