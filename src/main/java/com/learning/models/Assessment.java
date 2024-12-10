package com.learning.models;

import java.util.UUID;

public class Assessment {
    private String id;
    private String title;
    private String description;
    private AssessmentType type;
    private double score;

    public Assessment(String title, String description, AssessmentType type) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.type = type;
        this.score = 0.0;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public AssessmentType getType() { return type; }
    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
}
