package com.example.library.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Book {
    private String author;
    private String title;
    private final String publishDate;

    public Book(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        publishDate = myDateObj.format(format);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }
}
