package com.taras_overmind.simplegraphicsapp.figures;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Ellipse implements Figure{

    float x, y, a, b;

    public Ellipse(float x, float y, float a, float b) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.b = b;
    }

    @Override
    public void draw(Canvas canvas, Paint paint1, Paint paint2) {
        float x0 = canvas.getWidth() / 2f;
        float y0 = canvas.getHeight() / 2f;
        canvas.drawOval(x0+sgmnt*(x-a), y0-sgmnt*(y-b), x0+sgmnt*(x+a), y0-sgmnt*(y+b), paint1);
        canvas.drawOval(x0+sgmnt*(x-a)+2, y0-sgmnt*(y-b)-2, x0+sgmnt*(x+a)-2, y0-sgmnt*(y+b)+2, paint2);
    }

    @Override
    public double getSquare() {
        return Math.PI*a*b;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
    }
}
