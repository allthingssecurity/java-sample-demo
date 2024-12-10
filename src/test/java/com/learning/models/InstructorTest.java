package com.learning.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InstructorTest {
    private Instructor instructor;

    @BeforeEach
    void setUp() {
        instructor = new Instructor("Test Instructor", "instructor@test.com", "Test Department");
    }

    @Test
    void testInstructorCreation() {
        assertNotNull(instructor.getId());
        assertEquals("Test Instructor", instructor.getName());
        assertEquals("instructor@test.com", instructor.getEmail());
        assertEquals("Test Department", instructor.getDepartment());
        assertTrue(instructor.getCourses().isEmpty());
    }

    @Test
    void testCreateCourse() {
        Course course = instructor.createCourse("Test Course", "Test Description");
        assertNotNull(course);
        assertEquals(1, instructor.getCourses().size());
        assertTrue(instructor.getCourses().contains(course));
        assertEquals(instructor, course.getInstructor());
    }

    @Test
    void testCreateAssessment() {
        Course course = instructor.createCourse("Test Course", "Test Description");
        Assessment assessment = instructor.createAssessment(course, "Test Quiz", "Quiz Description", AssessmentType.QUIZ);
        
        assertNotNull(assessment);
        assertEquals("Test Quiz", assessment.getTitle());
        assertEquals("Quiz Description", assessment.getDescription());
        assertEquals(AssessmentType.QUIZ, assessment.getType());
        assertTrue(course.getAssessments().contains(assessment));
    }
}
