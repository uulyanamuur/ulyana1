package com.example.ulyana1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
//import android.os.CountDownTimer;
import android.view.View;

    public class MyView extends View {

        int N = 100;
        int RADIUS = 30;
        float[]x = new float[N];
        float[]y = new float[N];
        float[]vx = new float[N];
        float[]vy = new float[N];

        int[] Red = new int[N];
        int[] Green = new int[N];
        int[] Blue = new int[N];
        boolean[] check = new boolean[N];
        public MyView(Context context) {
            super(context);
        /*for(int i = 0; i < N;i++){
            x[i] = (float)(Math.random() * 500);
            y[i] = (float)(Math.random() * 500);
            vx[i] = (float)(Math.random() * 6 -3);
            vy[i] = (float)(Math.random() * 6 - 3);
        }*/
        }
        Paint paint = new Paint();
        //float x = 0;
        //long lastTime = System.currentTimeMillis();

        boolean isStart = false;

        boolean isBeforeStart = false;
        boolean whileTheyAreFalling = true;
        @Override
        protected void onDraw(Canvas canvas){
            //canvas.drawCircle(x,300,20,paint);
            //x+=0.5f;
        /*long nowTime = System.currentTimeMillis();
        x += 0.1f * (nowTime-lastTime);
        lastTime = nowTime;
        invalidate();*/

                if(!isBeforeStart) {
                    for(int i = 0; i < N;i++) {
                        x[i] = (float) (Math.random() * this.getWidth());
                        y[i] = (float) (Math.random() * this.getHeight());
                        vx[i] = 0;
                        vy[i] = 9.8f;
                        Red[i] = (int) (Math.random()*255);
                        Green[i] = (int) (Math.random()*255);
                        Blue[i] = (int) (Math.random()*255);
                        check[i]=false;
                    }
                    for(int i = 0; i < N;i++){
                        for(int j = i+1;j<N;j++){
                            if(Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]))<=2*RADIUS){
                                x[i] = (float) (Math.random() * this.getWidth());
                                y[i] = (float) (Math.random() * this.getHeight());
                                i = 0; j = 0;
                            }
                        }
                    }
                    isBeforeStart = true;
                }
                else if(whileTheyAreFalling) {
                    for(int i = 0; i < N;i++){
                        for(int j = i+1; j < N;j++){
                            if(Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]))<=2*RADIUS){
                                vy[i] = 0;
                                vy[j] = 0;
                                check[i]=true;
                                check[j]=true;
                            }
                        }
                        if(y[i]>=this.getHeight()){
                            vy[i]=0;
                            check[i] = true;
                        }
                    }
                    for(int i = 0; i < N;i++){
                        if(!check[i]){
                            break;
                        }
                        if(i==N-1){
                            whileTheyAreFalling = false;
                        }
                    }
                }
                else if(!isStart){
                    for(int i = 0; i < N;i++){
                        vx[i] = (float)(Math.random() * 20 - 10);
                        vy[i] = (float)(Math.random() * 20 - 10);
                    }
                    isStart = true;
                }
                else{
                    for(int i = 0; i < N;i++){
                        for(int j = i+1; j < N;j++){
                            if(Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]))<=2*RADIUS){
                                vx[i] = (float)(Math.random() * 20 - 10);
                                vy[i] = (float)(Math.random() * 20 - 10);
                                vx[j] = vx[i]*(-1);
                                vy[j] = vy[i]*(-1);
                                Red[i] = (int) (Math.random()*255);
                                Green[i] = (int) (Math.random()*255);
                                Blue[i] = (int) (Math.random()*255);
                                Red[j] = (int) (Math.random()*255);
                                Green[j] = (int) (Math.random()*255);
                                Blue[j] = (int) (Math.random()*255);
                            }
                        }
                /*if(x[i]-RADIUS<=0||x[i]+RADIUS>=this.getWidth()||y[i]-RADIUS<=0||y[i]+RADIUS>=this.getHeight()){
                    vx[i] = (float)(Math.random() * 20 - 10);
                    vy[i] = (float)(Math.random() * 20 - 10);
                }*/
                        if(x[i]-RADIUS<=0||x[i]+RADIUS>=this.getWidth()){
                            vx[i]*=(-1);
                            Red[i] = (int) (Math.random()*255);
                            Green[i] = (int) (Math.random()*255);
                            Blue[i] = (int) (Math.random()*255);
                        }
                        if(y[i]-RADIUS<=0||y[i]+RADIUS>=this.getHeight()){
                            vy[i]*=(-1);
                            Red[i] = (int) (Math.random()*255);
                            Green[i] = (int) (Math.random()*255);
                            Blue[i] = (int) (Math.random()*255);
                        }
                    }

                }
                for (int i = 0; i < N; i++) {
                    paint.setColor(Color.rgb(Red[i],Green[i],Blue[i]));
                    canvas.drawCircle(x[i], y[i], RADIUS, paint);
                }
                for (int i = 0; i < N; i++) {
                    x[i] += vx[i];
                    y[i] += vy[i];
                }invalidate();
            }

        }



    /*int N = 15;
    int[] l = new int [N];
    double x0,y0;
    double[]x = new double [N];
    double[]y = new double[N];
    double g = 9.832f,pi = Math.PI;
    double[] w = new double[N];
    double fi0;
    double[] fi = new double[N];
    int t = 0, deltaT = 1;

    void makePendulum(){
        fi0 = pi/4;

        int l_min = 100;
        for(int i = 0; i <  N;i++){
            l[i] = l_min;
            l_min+=50;

            w[i] = Math.sqrt(g/l[i]);
        }
    }
    void movePendulum(){
        t+=deltaT;

        for(int i = 0; i<N;i++){
            fi[i]=fi0*Math.cos(w[i]*t);
            x[i] = l[i]*Math.sin(fi[i]);
            y[i] = l[i]*Math.cos(fi[i]);
        }
    }

    public MyView(Context context) {
        super(context);
        makePendulum();
        MyTimer timer = new MyTimer();
        timer.start();
    }

    @Override
    protected void onDraw(Canvas canvas){
        x0 = getWidth()/2;
        y0 = getHeight()/4;
        Paint paint = new Paint();
        canvas.drawCircle((float)x0,(float)y0,10,paint);
        for(int i = 0; i < N;i++){
            paint.setColor(Color.BLUE);
            canvas.drawLine((float)x0,(float)y0,(float)(x[i]+x0),(float)(y[i]+y0),paint);
            paint.setColor(Color.RED);
            canvas.drawCircle((float)(x[i]+x0),(float)(y[i]+y0),20,paint);
        }
    }

    void nextFrame(){
        movePendulum();
        invalidate();
    }

    class MyTimer extends CountDownTimer{

        MyTimer(){
            super(100000,100);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            nextFrame();
        }

        @Override
        public void onFinish() {

        }
    }
}
*/