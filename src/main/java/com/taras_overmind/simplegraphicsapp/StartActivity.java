package com.taras_overmind.simplegraphicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Get references to the buttons
        Button buttonDrawCircle = findViewById(R.id.buttonDrawCircle);
        Button buttonDrawOval = findViewById(R.id.buttonDrawOval);
        Button buttonDrawRectangle = findViewById(R.id.buttonDrawRectangle);
        Button buttonDrawTriangle = findViewById(R.id.buttonDrawTriangle);
        Button buttonPersonalPage = findViewById(R.id.buttonPersonalPage);

        // Set click listeners for the buttons
        buttonDrawCircle.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, CircleActivity.class);
            startActivity(intent);
        });
        buttonDrawOval.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, OvalActivity.class);
            startActivity(intent);
        });
        buttonDrawRectangle.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, RectangleActivity.class);
            startActivity(intent);
        });
        buttonDrawTriangle.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, TriangleActivity.class);
            startActivity(intent);
        });
        buttonPersonalPage.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, PersonalPageActivity.class);
            startActivity(intent);
        });
    }
}