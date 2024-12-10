package com.learning.models;

import com.learning.exceptions.LMSException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student {
    private static final Logger logger = LoggerFactory.getLogger(Student.class);

    private final String id;
    private final String name;
    private final String email;
    private final List<Course> enrolledCourses;
    private final List<Assessment> completedAssessments;

    private Student(Builder builder) {
        this.id = UUID.randomUUID().toString();
        this.name = Objects.requireNonNull(builder.name, "Name cannot be null");
        this.email = validateEmail(builder.email);
        this.enrolledCourses = new ArrayList<>();
        this.completedAssessments = new ArrayList<>();
    }

    private String validateEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new LMSException("Invalid email format");
        }
        return email;
    }

    public void enrollInCourse(Course course) {
        Objects.requireNonNull(course, "Course cannot be null");
        if (!enrolledCourses.contains(course)) {
            logger.info("Enrolling student {} in course {}", this.id, course.getId());
            enrolledCourses.add(course);
            course.addStudent(this);
        }
    }

    public void completeAssessment(Assessment assessment, double score) {
        Objects.requireNonNull(assessment, "Assessment cannot be null");
        if (score < 0 || score > 100) {
            throw new LMSException("Score must be between 0 and 100");
        }
        assessment.setScore(score);
        completedAssessments.add(assessment);
        logger.info("Student {} completed assessment {} with score {}", this.id, assessment.getId(), score);
    }

    public double getAverageScore() {
        if (completedAssessments.isEmpty()) {
            return 0.0;
        }
        return completedAssessments.stream()
                .mapToDouble(Assessment::getScore)
                .average()
                .orElse(0.0);
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Course> getEnrolledCourses() { return new ArrayList<>(enrolledCourses); }
    public List<Assessment> getCompletedAssessments() { return new ArrayList<>(completedAssessments); }

    public static class Builder {
        private String name;
        private String email;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
