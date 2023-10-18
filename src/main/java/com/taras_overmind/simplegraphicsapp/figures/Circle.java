package com.taras_overmind.simplegraphicsapp.figures;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Circle implements Figure{
    private float x, y, radius;

    public Circle(float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw(Canvas canvas, Paint paint1, Paint paint2) {
        float x0= canvas.getWidth()/2f;
        float y0= canvas.getHeight()/2f;
        canvas.drawCircle(x0 + x * sgmnt, y0 - y * sgmnt, radius * sgmnt, paint1);
        canvas.drawCircle(x0  + x * sgmnt, y0 - y * sgmnt, radius * sgmnt - 2, paint2);
    }

    @Override
    public double getSquare() {
        return Math.PI*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }
}
