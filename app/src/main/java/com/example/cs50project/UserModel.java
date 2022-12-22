package com.example.cs50project;

import android.widget.ImageView;

import java.io.Serializable;

public class UserModel implements Serializable {
    private int image;
    private String title;
    private String author;
    private String category;


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

    public UserModel(int image, String title, String author, String category) {
        this.image = image;
        this.title = title;
        this.author = author;
        this.category = category;

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