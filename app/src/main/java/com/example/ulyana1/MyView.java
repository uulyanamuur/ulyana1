import android.content.Context;
import android.graphics.*;
import android.view.View;

public class MyView extends View {
    Paint paint = new Paint();
    int N = 10;
    int j=0;
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    int[] col = new int[3*N];
    boolean started;

    float rand(float min , float max){
        return (float)(Math.random() * (max - min + 1)) + min;
    }
    int rand(int min , int max){
        return (int) ((Math.random() * (max - min + 1)) + min);
    }
    void fillRandom(float[] array , float min, float max){
        for (int i = 0; i < array.length; i++){
            array[i] = rand (min, max);
        }
    }
    void fillRandom(int[] array , int min, int max){
        for (int i = 0; i < array.length; i++){
            array[i] = rand (min, max);
        }
    }

    void drawBalls(int array[],float arrayx[], float arrayy[],Canvas canvas){
        j=0;
        for (int i = 0; i < N; i++) {
            paint.setARGB(array[j], array[j + 1], array[j + 2], 0);
            canvas.drawCircle(arrayx[i], arrayy[i], 20, paint);
            j += 3;
        }
    }

    void add(float[] array , float[] values,Canvas canvas){
        for (int i = 0; i < array.length; i++){
            if (array[i] < 0 || array[i] > canvas.getWidth()) {
                values[i] = -values[i];
                array[i] += values[i];
            } else array[i] += values[i];
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        if (!started) {
            fillRandom(x, 0, canvas.getWidth());
            fillRandom(y, 0, canvas.getHeight());
            fillRandom(vx, -3, 3);
            fillRandom(vy, -3,3);
            fillRandom(col,0,255);
            fillRandom(col,0,255);
            started = true;
        }
        j = 0;
        drawBalls(col,x,y,canvas);
        add(x,vx,canvas);
        add(y,vy,canvas);


        invalidate();
    }
    public MyView(Context context) {
        super(context);

    }
}