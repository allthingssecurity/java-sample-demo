# Learning Management System (Spring Boot)

A comprehensive Learning Management System built with Spring Boot that demonstrates RESTful API design, clean architecture, and modern Java practices.

## Project Structure

```
src/main/java/com/learning/
├── LearningManagementApplication.java
├── controllers/
│   ├── StudentController.java
│   └── CourseController.java
├── services/
│   ├── StudentService.java
│   └── CourseService.java
├── models/
│   ├── Student.java
│   ├── Instructor.java
│   ├── Course.java
│   ├── Assessment.java
│   └── AssessmentType.java
├── dto/
│   ├── StudentDTO.java
│   └── CourseDTO.java
└── exceptions/
    └── LMSException.java

src/main/resources/
└── application.properties

src/test/java/com/learning/
├── models/
│   ├── StudentTest.java
│   └── CourseTest.java
└── services/
    └── LearningManagementSystemTest.java
```

## Features

- RESTful API endpoints for course management
- Student enrollment and assessment tracking
- Instructor management
- Course creation and management
- Performance analytics
- Input validation and error handling
- Comprehensive test coverage

## API Endpoints

### Student Operations
```http
POST /api/students                          # Create student
GET /api/students/{id}                      # Get student
GET /api/students                           # Get all students
POST /api/students/{id}/courses/{courseId}  # Enroll in course
POST /api/students/{id}/assessments/{id}    # Submit assessment
```

### Course Operations
```http
POST /api/courses                           # Create course
GET /api/courses/{id}                       # Get course
GET /api/courses                            # Get all courses
GET /api/courses/{id}/students              # Get enrolled students
GET /api/courses/{id}/average-score         # Get course average
```

## Technology Stack

- Java 11
- Spring Boot 2.7.0
- Spring Web
- Spring Validation
- Spring Actuator
- SLF4J & Logback
- JUnit 5
- Mockito
- Gradle

## Getting Started

1. Clone the repository
```bash
git clone https://github.com/allthingssecurity/java-sample-demo.git
```

2. Build the project
```bash
./gradlew build
```

3. Run the application
```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`

## Development

### Building
```bash
./gradlew clean build
```

### Testing
```bash
./gradlew test
```

### Code Coverage
```bash
./gradlew jacocoTestReport
```
Coverage reports will be generated in `build/jacocoHtml/`

## Design Patterns & Principles

- REST API design principles
- DTO pattern for request/response
- Service layer architecture
- Dependency injection
- Builder pattern for object creation
- Comprehensive exception handling

## Monitoring

The application includes Spring Actuator endpoints for monitoring:
- Health check: `/actuator/health`
- Metrics: `/actuator/metrics`
- Info: `/actuator/info`

## Future Enhancements

- Database integration (PostgreSQL/MongoDB)
- Authentication and Authorization
- Swagger/OpenAPI documentation
- File upload for assignments
- Email notifications
- Caching layer
- Docker containerization
- CI/CD pipeline

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details