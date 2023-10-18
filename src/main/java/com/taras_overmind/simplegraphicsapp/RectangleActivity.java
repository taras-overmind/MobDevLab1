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

import com.taras_overmind.simplegraphicsapp.figures.Rectangle;

public class RectangleActivity extends AppCompatActivity {
    private EditText editTextCoordinates, editTextLength, editTextWidth;
    private LinearLayout linearLayoutCanvas;
    private TextView textViewSquare;
    private TextView textViewPerimeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        editTextCoordinates = findViewById(R.id.editTextCoordinates);
        editTextLength = findViewById(R.id.editTextLength);
        editTextWidth = findViewById(R.id.editTextWidth);
        linearLayoutCanvas = findViewById(R.id.linearLayoutCanvas);
        textViewSquare = findViewById(R.id.editTextSquare);
        textViewPerimeter = findViewById(R.id.editTextPerimeter);

        Button buttonDrawCircle = findViewById(R.id.buttonDrawCircle);
        buttonDrawCircle.setOnClickListener(view -> drawRectangle());
    }

    @SuppressLint("SetTextI18n")
    private void drawRectangle() {
        try {
            String coordinatesString = editTextCoordinates.getText().toString();
            if (coordinatesString.matches("\\(\\d+;\\d+\\)")) {
                // Extract and parse x and y values
                String[] coordinates = coordinatesString.substring(1, coordinatesString.length() - 1).split(";");
                float x = Float.parseFloat(coordinates[0]);
                float y = Float.parseFloat(coordinates[1]);
                float length = Float.parseFloat(editTextLength.getText().toString());
                float width = Float.parseFloat(editTextWidth.getText().toString());

                Rectangle rectangle = new Rectangle(x, y, length, width);
                DrawView drawView = new DrawView(this, rectangle);

                linearLayoutCanvas.removeAllViews();
                linearLayoutCanvas.addView(drawView);

                textViewSquare.setText("Square = " + rectangle.getSquare());
                textViewPerimeter.setText("Perimeter = " + rectangle.getPerimeter());

            } else {
                throw new FormatException();
            }
        } catch (Exception ex) {
            Toast.makeText(RectangleActivity.this, "Invalid coordinates format. Please use (x;y).", Toast.LENGTH_SHORT).show();
        }
    }
}