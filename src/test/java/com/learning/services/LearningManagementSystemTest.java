package com.learning.services;

import com.learning.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LearningManagementSystemTest {
    private LearningManagementSystem lms;

    @BeforeEach
    void setUp() {
        lms = new LearningManagementSystem();
    }

    @Test
    void testRegisterStudent() {
        Student student = lms.registerStudent("Test Student", "student@test.com");
        assertNotNull(student);
        assertEquals("Test Student", student.getName());
        assertEquals("student@test.com", student.getEmail());
    }

    @Test
    void testRegisterInstructor() {
        Instructor instructor = lms.registerInstructor("Test Instructor", "instructor@test.com", "Test Department");
        assertNotNull(instructor);
        assertEquals("Test Instructor", instructor.getName());
        assertEquals("instructor@test.com", instructor.getEmail());
        assertEquals("Test Department", instructor.getDepartment());
    }

    @Test
    void testCreateCourse() {
        Instructor instructor = lms.registerInstructor("Test Instructor", "instructor@test.com", "Test Department");
        Course course = lms.createCourse(instructor, "Test Course", "Test Description");
        
        assertNotNull(course);
        assertEquals("Test Course", course.getName());
        assertEquals("Test Description", course.getDescription());
        assertEquals(instructor, course.getInstructor());
    }

    @Test
    void testEnrollStudentInCourse() {
        Student student = lms.registerStudent("Test Student", "student@test.com");
        Instructor instructor = lms.registerInstructor("Test Instructor", "instructor@test.com", "Test Department");
        Course course = lms.createCourse(instructor, "Test Course", "Test Description");
        
        lms.enrollStudentInCourse(student.getId(), course.getId());
        
        assertTrue(student.getEnrolledCourses().contains(course));
        assertTrue(course.getEnrolledStudents().contains(student));
    }

    @Test
    void testGetAvailableCourses() {
        Instructor instructor = lms.registerInstructor("Test Instructor", "instructor@test.com", "Test Department");
        Course course1 = lms.createCourse(instructor, "Course 1", "Description 1");
        Course course2 = lms.createCourse(instructor, "Course 2", "Description 2");
        
        var courses = lms.getAvailableCourses();
        assertEquals(2, courses.size());
        assertTrue(courses.contains(course1));
        assertTrue(courses.contains(course2));
    }

    @Test
    void testGetEnrolledStudents() {
        Student student1 = lms.registerStudent("Student 1", "student1@test.com");
        Student student2 = lms.registerStudent("Student 2", "student2@test.com");
        Instructor instructor = lms.registerInstructor("Test Instructor", "instructor@test.com", "Test Department");
        Course course = lms.createCourse(instructor, "Test Course", "Test Description");
        
        lms.enrollStudentInCourse(student1.getId(), course.getId());
        lms.enrollStudentInCourse(student2.getId(), course.getId());
        
        var enrolledStudents = lms.getEnrolledStudents(course.getId());
        assertEquals(2, enrolledStudents.size());
        assertTrue(enrolledStudents.contains(student1));
        assertTrue(enrolledStudents.contains(student2));
    }

    @Test
    void testGetCourseAverages() {
        Student student = lms.registerStudent("Test Student", "student@test.com");
        Instructor instructor = lms.registerInstructor("Test Instructor", "instructor@test.com", "Test Department");
        Course course = lms.createCourse(instructor, "Test Course", "Test Description");
        
        lms.enrollStudentInCourse(student.getId(), course.getId());
        
        Assessment assessment = instructor.createAssessment(course, "Test Quiz", "Description", AssessmentType.QUIZ);
        student.completeAssessment(assessment, 90.0);
        
        var averages = lms.getCourseAverages();
        assertEquals(90.0, averages.get(course.getName()));
    }
}
