package com.chillingvan.canvasglsample.demo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chillingvan.canvasglsample.MainActivity;
import com.chillingvan.canvasglsample.R;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_demo);
        //Set a Rect for the 200 x 200 px center of a 400 x 400 px area
        Rect rect = new Rect();
        rect.set(100, 100, 300, 300);

        //Allocate a new Bitmap at 400 x 400 px
        Bitmap bitmap = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        //Make a new view and lay it out at the desired Rect dimensions
        TextView view = new TextView(this);
        view.setText("This is a custom drawn textview");
        view.setBackgroundColor(Color.RED);
        view.setGravity(Gravity.CENTER);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DemoActivity.this, "aaa", Toast.LENGTH_SHORT).show();
            }
        });

        //Measure the view at the exact dimensions (otherwise the text won't center correctly)
        int widthSpec = View.MeasureSpec.makeMeasureSpec(rect.width(), View.MeasureSpec.EXACTLY);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(rect.height(), View.MeasureSpec.EXACTLY);
        view.measure(widthSpec, heightSpec);

        //Lay the view out at the rect width and height
        view.layout(0, 0, rect.width(), rect.height());

        //Translate the Canvas into position and draw it
        canvas.save();
        canvas.translate(rect.left, rect.top);
        view.draw(canvas);
        canvas.restore();

        //To make sure it works, set the bitmap to an ImageView
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(imageView);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageBitmap(bitmap);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DemoActivity.this, "bbb", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
