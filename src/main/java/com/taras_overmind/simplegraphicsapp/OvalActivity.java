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

import com.taras_overmind.simplegraphicsapp.figures.Ellipse;

public class OvalActivity extends AppCompatActivity {

    private EditText editTextCoordinates, editTextA, editTextB;
    private LinearLayout linearLayoutCanvas;
    private TextView textViewSquare;
    private TextView textViewPerimeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oval);

        editTextCoordinates = findViewById(R.id.editTextCoordinates);
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        linearLayoutCanvas = findViewById(R.id.linearLayoutCanvas);
        textViewSquare = findViewById(R.id.editTextSquare);
        textViewPerimeter = findViewById(R.id.editTextPerimeter);

        Button buttonDrawCircle = findViewById(R.id.buttonDrawCircle);
        buttonDrawCircle.setOnClickListener(view -> drawOval());
    }

    @SuppressLint("SetTextI18n")
    private void drawOval() {
        try {
            String coordinatesString = editTextCoordinates.getText().toString();
            if (coordinatesString.matches("\\(\\d+;\\d+\\)")) {
                // Extract and parse x and y values
                String[] coordinates = coordinatesString.substring(1, coordinatesString.length() - 1).split(";");
                float x = Float.parseFloat(coordinates[0]);
                float y = Float.parseFloat(coordinates[1]);
                float a = Float.parseFloat(editTextA.getText().toString());
                float b = Float.parseFloat(editTextB.getText().toString());

                Ellipse ellipse = new Ellipse(x, y, a, b);
                DrawView drawView = new DrawView(this, ellipse);

                linearLayoutCanvas.removeAllViews();
                linearLayoutCanvas.addView(drawView);

                textViewSquare.setText("Square = " + ellipse.getSquare());
                textViewPerimeter.setText("Perimeter = " + ellipse.getPerimeter());

            } else {
                throw new FormatException();
            }
        } catch (Exception ex) {
            Toast.makeText(OvalActivity.this, "Invalid coordinates format. Please use (x;y).", Toast.LENGTH_SHORT).show();
        }
    }
}