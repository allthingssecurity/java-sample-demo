package com.learning.controllers;

import com.learning.dto.CourseDTO;
import com.learning.models.Course;
import com.learning.models.Student;
import com.learning.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@Valid @RequestBody CourseDTO courseDTO) {
        Course course = courseService.createCourse(courseDTO);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable String id) {
        return ResponseEntity.ok(courseService.getCourse(id));
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<Student>> getEnrolledStudents(@PathVariable String id) {
        return ResponseEntity.ok(courseService.getEnrolledStudents(id));
    }

    @GetMapping("/{id}/average-score")
    public ResponseEntity<Double> getCourseAverageScore(@PathVariable String id) {
        return ResponseEntity.ok(courseService.getCourseAverageScore(id));
    }
}
