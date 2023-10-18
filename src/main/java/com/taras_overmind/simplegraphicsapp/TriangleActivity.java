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

import com.taras_overmind.simplegraphicsapp.figures.Triangle;

public class TriangleActivity extends AppCompatActivity {


    private EditText editTextCoordinates1, editTextCoordinates2, editTextCoordinates3;
    private LinearLayout linearLayoutCanvas;
    private TextView textViewSquare;
    private TextView textViewPerimeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        editTextCoordinates1 = findViewById(R.id.editTextCoordinates1);
        editTextCoordinates2 = findViewById(R.id.editTextCoordinates2);
        editTextCoordinates3 = findViewById(R.id.editTextCoordinates3);
        linearLayoutCanvas = findViewById(R.id.linearLayoutCanvas);
        textViewSquare = findViewById(R.id.editTextSquare);
        textViewPerimeter = findViewById(R.id.editTextPerimeter);

        Button buttonDrawCircle = findViewById(R.id.buttonDrawCircle);
        buttonDrawCircle.setOnClickListener(view -> drawTriangle());
    }

    @SuppressLint("SetTextI18n")
    private void drawTriangle() {
        try {
            String coordinatesString1 = editTextCoordinates1.getText().toString();
            String coordinatesString2 = editTextCoordinates2.getText().toString();
            String coordinatesString3 = editTextCoordinates3.getText().toString();
            if (coordinatesString1.matches("\\(\\d+;\\d+\\)") &&
                    coordinatesString2.matches("\\(\\d+;\\d+\\)")&&
                    coordinatesString3.matches("\\(\\d+;\\d+\\)")) {
                // Extract and parse x and y values
                String[] coordinates1 = coordinatesString1.substring(1, coordinatesString1.length() - 1).split(";");
                String[] coordinates2 = coordinatesString2.substring(1, coordinatesString2.length() - 1).split(";");
                String[] coordinates3 = coordinatesString3.substring(1, coordinatesString3.length() - 1).split(";");
                float x1 = Float.parseFloat(coordinates1[0]);
                float y1 = Float.parseFloat(coordinates1[1]);
                float x2 = Float.parseFloat(coordinates2[0]);
                float y2 = Float.parseFloat(coordinates2[1]);
                float x3 = Float.parseFloat(coordinates3[0]);
                float y3 = Float.parseFloat(coordinates3[1]);

                Triangle triangle = new Triangle(x1, y1, x2, y2, x3, y3);
                DrawView drawView = new DrawView(this, triangle);

                linearLayoutCanvas.removeAllViews();
                linearLayoutCanvas.addView(drawView);

                textViewSquare.setText("Square = " + triangle.getSquare());
                textViewPerimeter.setText("Perimeter = " + triangle.getPerimeter());

            } else {
                throw new FormatException();
            }
        } catch (Exception ex) {
            Toast.makeText(TriangleActivity.this, "Invalid coordinates format. Please use (x;y).", Toast.LENGTH_SHORT).show();
        }
    }
}