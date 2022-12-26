package com.example.cs50project;

import android.widget.ImageView;

import java.io.Serializable;

public class UserModel implements Serializable {
    private int image;
    private String title;
    private String author;
    private String category;
    private String pages;
    private String date;
    private String description;


    public UserModel(int image, String title, String author, String category, String pages, String date, String description) {
        this.image = image;
        this.title = title;
        this.author = author;
        this.category = category;
        this.pages = pages;
        this.date = date;
        this.description = description;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}