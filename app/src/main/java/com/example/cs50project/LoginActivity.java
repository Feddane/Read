package com.example.cs50project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//all about Sign In button
public class LoginActivity extends AppCompatActivity {
    EditText username, Password;
    Button signin;
    DBHelper DB = new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        Password = findViewById(R.id.password1);
        signin = findViewById(R.id.signin1);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String password = Password.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "All fields required !", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserpassword = DB.checkusernamepassword(user, password);
                    if (checkuserpassword == true) {
                        Toast.makeText(LoginActivity.this, "login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "login Failed", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }

}