package com.taras_overmind.simplegraphicsapp.figures;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Triangle implements Figure {
    float x1, y1, x2, y2, x3, y3;

    public Triangle(float x1, float y1, float x2, float y2, float x3, float y3) throws Exception {
        if (arePointsCollinear(x1, y1, x2, y2, x3, y3)) {
            throw new Exception("Points are collinear. Cannot form a triangle.");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public void draw(Canvas canvas, Paint paint1, Paint paint2) {
        float x0 = canvas.getWidth() / 2f;
        float y0 = canvas.getHeight() / 2f;
        canvas.drawLine(x0 + x1 * sgmnt, y0 - y1 * sgmnt, x0 + x2 * sgmnt, y0 - y2 * sgmnt, paint1);
        canvas.drawLine(x0 + x2 * sgmnt, y0 - y2 * sgmnt, x0 + x3 * sgmnt, y0 - y3 * sgmnt, paint1);
        canvas.drawLine(x0 + x1 * sgmnt, y0 - y1 * sgmnt, x0 + x3 * sgmnt, y0 - y3 * sgmnt, paint1);
    }

    @Override
    public double getSquare() {
        double a = distance(x1, y1, x2, y2);
        double b = distance(x2, y2, x3, y3);
        double c = distance(x3, y3, x1, y1);
        double s = getPerimeter() / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        double a = distance(x1, y1, x2, y2);
        double b = distance(x2, y2, x3, y3);
        double c = distance(x3, y3, x1, y1);

        return a + b + c;
    }

    private double distance(float x1, float y1, float x2, float y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private boolean arePointsCollinear(float x1, float y1, float x2, float y2, float x3, float y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2) == 0;
    }
}
