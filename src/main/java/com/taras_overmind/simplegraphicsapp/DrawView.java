package com.taras_overmind.simplegraphicsapp;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.taras_overmind.simplegraphicsapp.figures.Figure;

public class DrawView extends View {

    private final Paint paint1;
    private final Paint paint2;
    private final Figure figure;

    public DrawView(Activity context, Figure figure) {
        super(context);

        this.figure=figure;

        paint1 = new Paint();
        paint1.setColor(Color.BLACK);
        paint2 = new Paint();
        paint2.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        figure.draw(canvas, paint1, paint2);

        drawCoordinateSystem(canvas);


    }
    static void drawCoordinateSystem(Canvas canvas) {
        int arrowSize = 10;
        float width = canvas.getWidth();
        float height = canvas.getHeight();
        float x0 = width / 2f;
        float y0 = height / 2f;
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        //axis
        canvas.drawLine(0, y0, width, y0, paint);
        canvas.drawLine(x0, height, x0, 0, paint);

        //arrows
        canvas.drawLine(width, y0, width - arrowSize, y0 - arrowSize, paint);
        canvas.drawLine(width, y0, width - arrowSize, y0 + arrowSize, paint);
        canvas.drawLine(x0, 0, x0 - arrowSize, arrowSize, paint);
        canvas.drawLine(x0, 0, x0 + arrowSize, arrowSize, paint);


        for (int i = -600; i < 700; i += 50) {
            if (i != 0) {
                canvas.drawLine(x0 + i, y0 - 5, x0 + i, y0 + 5, paint);
                canvas.drawLine(x0 - 5, y0 + i, x0 + 5, y0 + i, paint);
            }
        }

    }

}
