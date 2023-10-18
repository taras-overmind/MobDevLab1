package com.taras_overmind.simplegraphicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.nfc.FormatException;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.taras_overmind.simplegraphicsapp.figures.Circle;

public class CircleActivity extends AppCompatActivity {
    private EditText editTextCoordinates, editTextRadius;
    private LinearLayout linearLayoutCanvas;
    private TextView textViewSquare;
    private TextView textViewPerimeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        editTextCoordinates = findViewById(R.id.editTextCoordinates);
        editTextRadius = findViewById(R.id.editTextRadius);
        linearLayoutCanvas = findViewById(R.id.linearLayoutCanvas);
        textViewSquare = findViewById(R.id.editTextSquare);
        textViewPerimeter = findViewById(R.id.editTextPerimeter);

        Button buttonDrawCircle = findViewById(R.id.buttonDrawCircle);
        buttonDrawCircle.setOnClickListener(view -> drawCircle());
    }

    @SuppressLint("SetTextI18n")
    private void drawCircle() {
        try {
            String coordinatesString = editTextCoordinates.getText().toString();
            if (coordinatesString.matches("\\(\\d+;\\d+\\)")) {
                // Extract and parse x and y values
                String[] coordinates = coordinatesString.substring(1, coordinatesString.length() - 1).split(";");
                float x = Float.parseFloat(coordinates[0]);
                float y = Float.parseFloat(coordinates[1]);
                float radius = Float.parseFloat(editTextRadius.getText().toString());
                Circle circle = new Circle(x, y, radius);
                DrawView drawView = new DrawView(this, circle);

                linearLayoutCanvas.removeAllViews();
                linearLayoutCanvas.addView(drawView);

                textViewSquare.setText("Square = " + circle.getSquare());
                textViewPerimeter.setText("Perimeter = " + circle.getPerimeter());

            } else {
                throw new FormatException();
            }
        } catch (Exception ex) {
            Toast.makeText(CircleActivity.this, "Invalid coordinates format. Please use (x;y).", Toast.LENGTH_SHORT).show();
        }
    }
}