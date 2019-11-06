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
        //### СИНИЙ КВАДРАТ
          paint.setColor(Color.BLUE);
          paint.setStyle(Paint.Style.FILL);
          canvas.drawRect(100, 100, 300, 300, paint);
    }
}