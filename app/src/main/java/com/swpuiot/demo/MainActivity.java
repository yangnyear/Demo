package com.swpuiot.demo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iv);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img);
        imageView.setImageBitmap(bitmap);

        Matrix matrix = new Matrix();
        matrix.postScale((float) (1.0 * dip2px(this, 200) / bitmap.getWidth()),
                (float) (1.0 * dip2px(this, 200) / bitmap.getHeight()));
        imageView.setImageMatrix(matrix);


        findViewById(R.id.left_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translate(0);
            }
        });
        findViewById(R.id.left_bottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translate(1);
            }
        });
        findViewById(R.id.right_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translate(2);
            }
        });
        findViewById(R.id.right_bottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translate(3);
            }
        });
        findViewById(R.id.center).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translate(4);
            }
        });


    }

    private void translate(int i) {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img);
        imageView.setImageBitmap(bitmap);
        Matrix matrix = new Matrix();
        matrix.postScale((float) (1.0 * dip2px(MainActivity.this, 400) / bitmap.getWidth()),
                (float) (1.0 * dip2px(this, 400) / bitmap.getHeight()));
        switch (i) {
            case 0:
                matrix.postTranslate(0, 0);
                break;
            case 1:
                matrix.postTranslate(0, dip2px(this, -200));
                break;
            case 2:
                matrix.postTranslate(dip2px(this, -200), 0);
                break;
            case 3:
                matrix.postTranslate(dip2px(this, -200), dip2px(this, -200));
                break;
            case 4:
                matrix.postTranslate(dip2px(this, -200) / 2, dip2px(this, -200) / 2);
                break;
        }
        imageView.setImageMatrix(matrix);
    }


    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
