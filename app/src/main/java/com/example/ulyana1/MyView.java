package com.example.ulyana1;

import android.content.Context;
//import android.graphics.Canvas;
import android.graphics.*;
import android.view.View;

public class MyView extends View {

    public MyView(Context context) { // конструктор, необходимый для нормальной работы
        super(context);
    }

    @Override

    protected void onDraw(Canvas canvas) { // создаем метод
        super.onDraw(canvas);
        Paint paint = new Paint();
        //### КРУГ
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(300, 300, 200, paint);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(300, 300, 200, paint);
    }
}