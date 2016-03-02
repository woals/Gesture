package com.yinyxn.gesture;

import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener{

    private static final String TAG = "MainActivity";

    GestureOverlayView overlayView;

    GestureLibrary library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        overlayView = new GestureOverlayView(this);
        overlayView.addView(getLayoutInflater().inflate(R.layout.activity_main,null));
        overlayView.setGestureVisible(true);
        setContentView(overlayView);

        library = GestureLibraries.fromRawResource(this,R.raw.gestures);
        library.load();
    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {

        ArrayList<Prediction> list = library.recognize(gesture);
        if(list.get(0).score > 2){
            String name = list.get(0).name;
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
            if(name.equals("v")){
                startActivity(new Intent(this,NextActivity.class));
            }
        }else {
            Toast.makeText(this, "手势未识别", Toast.LENGTH_SHORT).show();
        }
    }
}
