package com.example.botonesdinamicos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int NUM_BOTONES = 15;
    private int screenWidth;
    private int buttonSize;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        screenWidth = point.x;
        buttonSize = screenWidth/3;

        añadeHijos();

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void añadeHijos(){
        GridLayout g= (GridLayout) findViewById(R.id.gridl1);
        Button b;
        int iden;
        for (int i=0; i<18; i++) {
            b = new Button(this);
            b.setLayoutParams(new ViewGroup.LayoutParams(buttonSize, buttonSize));
            b.setPadding(0, 0,0, 0);
            iden = View.generateViewId();
            b.setId(iden);
            b.setBackgroundColor(setColorAleatorio());
            b.setAlpha(1);
            b.setOnClickListener(this);
            g.addView(b,i);
        }
    }

    private int setColorAleatorio() {
        int numRandom = (int) (Math.random()*5)+1;
        switch (numRandom) {
            case 1:
                return Color.rgb(192, 57, 43);
            case 2:
                return Color.rgb(52, 152, 219);
            case 3:
                return Color.rgb(46, 204, 113);
            case 4:
                return Color.rgb(241, 196, 15);
            case 5:
                return Color.rgb(142, 68, 173);
            default:
                return Color.MAGENTA;
        }
    }

    @Override
    public void onClick(View v) {
        Button b2 = (Button) v;
        cambioColor(b2);
    }

    private void cambioColor(Button b2) {
        if (b2.getAlpha() > 0) {
            b2.setAlpha(b2.getAlpha() - 0.3f);
        }
    }
}