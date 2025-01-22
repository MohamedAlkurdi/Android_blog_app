package com.example.blogappproject;

import java.util.UUID;

public class Task {
    private String id; // Unique ID (UUID recommended)
    private String title;
    private String description;
    private String author;
    private boolean isCompleted;

    public Task() {}

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.author = "fakeemail@gmail.com"; //will be automatically replaced with the current user's email
        this.isCompleted = false;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
}