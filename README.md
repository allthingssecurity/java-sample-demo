# Student Learning Management System

A Java-based Learning Management System (LMS) that demonstrates object-oriented programming principles and clean architecture.

## Features

- Student registration and course enrollment
- Instructor management and course creation
- Different types of assessments (Quiz, Assignment, Project, Exam)
- Course performance tracking and analytics
- Grade management and reporting

## Project Structure

```
src/main/java/com/learning/
├── models/
│   ├── Student.java
│   ├── Instructor.java
│   ├── Course.java
│   ├── Assessment.java
│   └── AssessmentType.java
├── services/
│   └── LearningManagementSystem.java
└── Main.java
```

## Design Patterns & Principles

- Singleton Pattern for LMS
- Observer Pattern for course updates
- Encapsulation of student and course data
- Immutable IDs using UUID
- Clean separation of concerns

## How to Run

1. Clone the repository
2. Compile the Java files
3. Run the Main class

## Sample Usage

Check the `Main.java` file for a complete example of system usage, including:
- Creating courses
- Registering students
- Managing assessments
- Generating reports

## Future Enhancements

- Database integration
- RESTful API
- User authentication
- File upload for assignments
- Real-time notifications
