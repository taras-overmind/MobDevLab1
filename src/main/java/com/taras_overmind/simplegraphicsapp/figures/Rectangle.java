package com.taras_overmind.simplegraphicsapp.figures;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Rectangle implements Figure{

    float x, y, length, width;

    public Rectangle(float x, float y, float length, float width) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw(Canvas canvas, Paint paint1, Paint paint2) {
        float x0 = canvas.getWidth() / 2f;
        float y0 = canvas.getHeight() / 2f;
        canvas.drawLine(x0+x*sgmnt, y0-y*sgmnt, x0+(x+length)*sgmnt, y0-y*sgmnt, paint1);
        canvas.drawLine(x0+x*sgmnt, y0-y*sgmnt, x0+x*sgmnt, y0-(y+width)*sgmnt, paint1);
        canvas.drawLine(x0+x*sgmnt, y0-(y+width)*sgmnt, x0+(x+length)*sgmnt, y0-(y+width)*sgmnt, paint1);
        canvas.drawLine(x0+(x+length)*sgmnt, y0-y*sgmnt, x0+(x+length)*sgmnt, y0-(y+width)*sgmnt, paint1);
    }

    @Override
    public double getSquare() {
        return width*length;
    }

    @Override
    public double getPerimeter() {
        return 2*length+2*width;
    }
}
