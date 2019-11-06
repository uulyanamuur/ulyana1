package com.example.ulyana1;

import android.content.Context;
//import android.graphics.Canvas;
import android.graphics.*;
import android.view.View;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }
    Paint paint = new Paint();
    float x = 50;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(x, 500, 30, paint);
        x += 1.5f;
        invalidate();
        }
    }

