package com.example.helloworld.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class DrawView extends View {

    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int[] x = new int[] {
                0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120 ,
        };
        double[] y = new double[] {
                5, 1, 7.5, 3, 4.5, 8.8, 15.5, 6.5, -5, -10, -2, 4.5, 7,
        };

        // 创建画笔
        Paint p = new Paint();
        p.reset();
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.RED);
        p.setStrokeWidth(5);
        Path path2=new Path();

        int canvasX = 0,canvasY = 0;

        for (int aimX = 0; aimX < 100; aimX++){
            double result = 0;
            for (int k = 0; k < y.length; k++) {
                double product = 1;
                System.out.println("result--> " + result);
                for (int i = 0; i < y.length; i++) {
                    if ( i != k ) {
                        System.out.println(( aimX - x[i] ) + " product-> \t" + ( x[k] - x[i] ) + " -> \t" + product);
                        product = product * ( aimX - x[i] )/( x[k] - x[i] );
                    }
                }
                result = result + y[k] * product;
            }
            path2.quadTo(canvasX, canvasY, aimX*10, (int)result*10+1000); //设置贝塞尔曲线的控制点坐标和终点坐标
            canvasX = aimX*10;
            canvasY = (int)result*10+1000;
        }
        canvas.drawPath(path2, p);//画出贝塞尔曲线
        Toast.makeText(getContext(), "贝塞尔曲线加载成功!", Toast.LENGTH_SHORT).show();
    }
}
