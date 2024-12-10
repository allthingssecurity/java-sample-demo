package com.learning.services;

import com.learning.dto.CourseDTO;
import com.learning.exceptions.LMSException;
import com.learning.models.Course;
import com.learning.models.Instructor;
import com.learning.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {
    private final Map<String, Course> courses = new HashMap<>();

    public Course createCourse(CourseDTO dto) {
        // Note: In a real application, you would inject InstructorService
        // and use it to get the instructor
        Instructor instructor = null; // instructorService.getInstructor(dto.getInstructorId());
        if (instructor == null) {
            throw new LMSException("Instructor not found with id: " + dto.getInstructorId());
        }
        
        Course course = new Course(dto.getName(), dto.getDescription(), instructor);
        courses.put(course.getId(), course);
        return course;
    }

    public Course getCourse(String id) {
        Course course = courses.get(id);
        if (course == null) {
            throw new LMSException("Course not found with id: " + id);
        }
        return course;
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses.values());
    }

    public List<Student> getEnrolledStudents(String courseId) {
        Course course = getCourse(courseId);
        return course.getEnrolledStudents();
    }

    public double getCourseAverageScore(String courseId) {
        Course course = getCourse(courseId);
        return course.getCourseAverageScore();
    }
}
