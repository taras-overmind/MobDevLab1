package com.taras_overmind.simplegraphicsapp.figures;

import android.graphics.Canvas;
import android.graphics.Paint;

public interface Figure {
    int sgmnt = 50;
    void draw(Canvas canvas, Paint paint1, Paint paint2);

    double getSquare();
    double getPerimeter();
}
