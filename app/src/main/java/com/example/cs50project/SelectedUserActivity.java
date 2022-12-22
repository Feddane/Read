package com.example.cs50project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SelectedUserActivity extends AppCompatActivity {

    TextView tvSelectedUserName;
    UserModel userModel;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_user);
        tvSelectedUserName = findViewById(R.id.tvSelectedUserName);
        intent = getIntent();

        if(intent != null){
            userModel = (UserModel) intent.getSerializableExtra("data");
            String title = userModel.getTitle();
            tvSelectedUserName.setText(title);
        }

    }
}