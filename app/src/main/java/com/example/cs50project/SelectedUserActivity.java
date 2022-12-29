package com.example.cs50project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectedUserActivity extends AppCompatActivity {

    TextView tvSelectedUserName, category, pages, date, description;
    ImageView image;
    UserModel userModel;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_user);
        tvSelectedUserName = findViewById(R.id.tvSelectedUserName);
        category = findViewById(R.id.category);
        image = findViewById(R.id.imageee);
        pages = findViewById(R.id.pages);
        date = findViewById(R.id.date);
        description = findViewById(R.id.Description);
        intent = getIntent();



        tvSelectedUserName.setText(getIntent().getExtras().getString("title"));
        category.setText(getIntent().getExtras().getString("Category"));
        pages.setText(getIntent().getExtras().getString("Pages"));
        date.setText(getIntent().getExtras().getString("Date"));
        description.setText(getIntent().getExtras().getString("description"));
        int booksimg = getIntent().getIntExtra("booksimg", 0);
        image.setImageResource(booksimg);

    }
}