package com.learning.services;

import com.learning.dto.StudentDTO;
import com.learning.exceptions.LMSException;
import com.learning.models.Assessment;
import com.learning.models.Course;
import com.learning.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private final Map<String, Student> students = new HashMap<>();

    public Student createStudent(StudentDTO dto) {
        Student student = new Student.Builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
        students.put(student.getId(), student);
        return student;
    }

    public Student getStudent(String id) {
        Student student = students.get(id);
        if (student == null) {
            throw new LMSException("Student not found with id: " + id);
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public void enrollInCourse(String studentId, String courseId) {
        Student student = getStudent(studentId);
        // Note: In a real application, you would inject CourseService
        // and use it to get the course
        Course course = null; // courseService.getCourse(courseId);
        if (course == null) {
            throw new LMSException("Course not found with id: " + courseId);
        }
        student.enrollInCourse(course);
    }

    public void submitAssessment(String studentId, String assessmentId, double score) {
        Student student = getStudent(studentId);
        // Note: In a real application, you would inject AssessmentService
        // and use it to get the assessment
        Assessment assessment = null; // assessmentService.getAssessment(assessmentId);
        if (assessment == null) {
            throw new LMSException("Assessment not found with id: " + assessmentId);
        }
        student.completeAssessment(assessment, score);
    }
}
