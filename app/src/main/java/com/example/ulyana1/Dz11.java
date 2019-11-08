package com.example.ulyana1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import java.util.Random;

abstract class Dz11 extends Activity implements OnClickListener, OnLongClickListener {

    private int WIDTH = 20;
    private int HEIGHT = 20;
    private Button[][] cells;

    @Override
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
}