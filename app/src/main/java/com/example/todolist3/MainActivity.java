package com.example.todolist3;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("LifeCycle","onCreate");

//        Button btn = new Button(this);
//        btn.setText("Push");
//        setContentView(btn);

        LinearLayout lo = new LinearLayout(this);
        lo.setOrientation(LinearLayout.VERTICAL);
        setContentView(lo);

//        Button btn1 = new Button(this);
//        btn1.setText("OK");
//        btn1.setOnClickListener(v -> {
//            Log.v("setOnClickListener","btn1");
//        });
//        btn1.setLayoutParams(new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//        ));
//
//        lo.addView(btn1);
//
//        Button btn2 = new Button(this);
//        btn2.setText("Cancel");
//        btn2.setOnClickListener(v -> {
//            Log.v("setOnClickListener","btn2");
//        });
//        btn2.setLayoutParams(new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//        ));
//        lo.addView(btn2);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.v("LifeCycle","onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.v("LifeCycle","onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.v("LifeCycle","onPause");
    }


    @Override
    public void onRestart(){
        super.onRestart();
        Log.v("LifeCycle","onRestart");
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.v("LifeCycle","onDestroy");
    }
}