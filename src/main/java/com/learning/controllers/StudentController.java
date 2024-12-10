package com.learning.controllers;

import com.learning.dto.StudentDTO;
import com.learning.models.Student;
import com.learning.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Student student = studentService.createStudent(studentDTO);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/{studentId}/courses/{courseId}/enroll")
    public ResponseEntity<Void> enrollInCourse(
            @PathVariable String studentId,
            @PathVariable String courseId) {
        studentService.enrollInCourse(studentId, courseId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{studentId}/assessments/{assessmentId}")
    public ResponseEntity<Void> submitAssessment(
            @PathVariable String studentId,
            @PathVariable String assessmentId,
            @RequestParam double score) {
        studentService.submitAssessment(studentId, assessmentId, score);
        return ResponseEntity.ok().build();
    }
}
