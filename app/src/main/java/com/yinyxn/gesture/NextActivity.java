package com.yinyxn.gesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

    private static final String TAG = "NextActivity";
    private GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        detector = new GestureDetector(this, new MyListener());
    }

    class MyListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            Log.d(TAG, String.format("onFling: x=%f, y=%f", velocityX, velocityY));

            float x1 = e1.getX();
            float y1 = e1.getY();
            float x2 = e1.getX();
            float y2 = e1.getY();

            String msg;
            if (Math.abs(x2 - x1) > Math.abs(y2 - y1)) {
                msg = x2 > x1 ? "右" : "左";
            } else {
                msg = y2 > y1 ? "下" : "上";
            }
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
