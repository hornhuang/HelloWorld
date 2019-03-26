package com.example.helloworld.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.helloworld.R;
import com.example.helloworld.draw.DrawView;

public class LagrangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lagrange);

        LinearLayout layout=(LinearLayout) findViewById(R.id.root);
        final DrawView view=new DrawView(this);
        view.setMinimumHeight(layout.getLayoutParams().width);
        view.setMinimumWidth(layout.getLayoutParams().height/2);
        //通知view组件重绘
        view.setBackgroundColor(Color.GRAY);
        view.invalidate();
        layout.addView(view);
    }
}
