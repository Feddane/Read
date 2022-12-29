package com.example.cs50project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Experience extends AppCompatActivity {
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<Integer>();
    TextInputEditText inputEditText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        textView = findViewById(R.id.soustitre);
        inputEditText = findViewById(R.id.textInputEditText);

        getImages();
    }

    public void updateText(View view){
        String sUsername = inputEditText.getText().toString();
        if (sUsername.matches("")) {
            Toast.makeText(this, "Please enter a text !⚠️", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Thank you 😊", Toast.LENGTH_SHORT).show();
        inputEditText.setText(null);

    }


    private void getImages(){
        mImageUrls.add(R.drawable.inlove);
        mNames.add("In love");

        mImageUrls.add(R.drawable.chocked);
        mNames.add("Chocked");

        mImageUrls.add(R.drawable.sad);
        mNames.add("Sad");

        mImageUrls.add(R.drawable.happy);
        mNames.add("Happy");

        mImageUrls.add(R.drawable.disapointed);
        mNames.add("Upset");

        mImageUrls.add(R.drawable.angry);
        mNames.add("Angry");

        initRecyclerView();
    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        ExperienceAdapter adapter = new ExperienceAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
    }

}