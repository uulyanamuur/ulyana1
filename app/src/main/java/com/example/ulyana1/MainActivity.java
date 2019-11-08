package com.example.ulyana1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.graphics.Color;


abstract class MainActivity extends Activity implements OnClickListener,
        OnLongClickListener {


    private int WIDTH = 10;
    private int HEIGHT = 10;
    private Button[][] cells;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        makeCells();
        generate();
    }



    void generate() {


        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {

                if ((i + j) % 2 == 0)
                    cells[i][j].setBackgroundColor(Color.WHITE);
                else
                    cells[i][j].setBackgroundColor(Color.BLACK);

            }



    }



    @Override

    public boolean onLongClick(View v) {

        Button tappedCell = (Button) v;

        //Получаем координтаты нажатой клетки

        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);

        for (int x = 0; x < WIDTH; x++)
        {
            cells[tappedY][x].setBackgroundColor(Color.GRAY);
        }
        for (int y = 0; y < WIDTH; y++)
        {
            cells[y][tappedX].setBackgroundColor(Color.GRAY);
        }


        return false;

    }



    @Override

    public void onClick(View v) {


        Button tappedCell = (Button) v;

        //Получаем координтаты нажатой клетки

        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);

        if ((tappedX + tappedY) % 2 == 0)
        {
            for (int i = 0; i < HEIGHT; i++)
                for (int j = 0; j < WIDTH; j++) {

                    if ((i + j) % 2 == 0)
                        cells[i][j].setBackgroundColor(Color.BLACK);
                    else
                        cells[i][j].setBackgroundColor(Color.WHITE);

                }
        }

        if ((tappedX + tappedY) % 2 != 0)
        {
            for (int i = 0; i < HEIGHT; i++)
                for (int j = 0; j < WIDTH; j++) {

                    if ((i + j) % 2 == 0)
                        cells[i][j].setBackgroundColor(Color.WHITE);
                    else
                        cells[i][j].setBackgroundColor(Color.BLACK);

                }
        }

    }



    int getX(View v) {

        return Integer.parseInt(((String) v.getTag()).split(",")[1]);

    }



    int getY(View v) {

        return Integer.parseInt(((String) v.getTag()).split(",")[0]);

    }



    void makeCells() {

        cells = new Button[HEIGHT][WIDTH];
        GridLayout cellsLayout = findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(HEIGHT);

        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {

                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                cells[i][j] = (Button) inflater.inflate(R.layout.activity_main, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);

            }
    }
}
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        generate();
    }

    int rand() {
        Random random = new Random();

        return (int) (Math.random() * 10);
    }

    void generate() {

        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
            }
        for (int i = 0; i < 5; i++) {
            cells[rand()][rand()].setBackgroundColor(Color.BLACK);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    int getX(View v)
    {
        return Integer.parseInt(((String) v.getTag()).split(",")[1]);
    }
    int getY(View v)
    {
        return  Integer.parseInt(((String)v.getTag()).split(",")[0]);
    }
    void makeCells() {
        cells = new Button[HEIGHT][WIDTH];
        GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(WIDTH);
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
    }
}*/