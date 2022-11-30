package com.dev.recyclerviewdemo;

public class Email {
    private String title;
    private String subject;
    private int imageResourceId;

    public Email(String title, String subject, int imageResourceId) {
        this.title = title;
        this.subject = subject;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
