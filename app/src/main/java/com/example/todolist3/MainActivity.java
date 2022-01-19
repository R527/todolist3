package com.example.todolist3;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String str = "0";
    String storageNum = "";
    String calculation;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("LifeCycle","onCreate");

        Button btn0 = (Button)findViewById(R.id.btn0);
        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn3 = (Button)findViewById(R.id.btn3);
        Button btn4 = (Button)findViewById(R.id.btn4);
        Button btn5 = (Button)findViewById(R.id.btn5);
        Button btn6 = (Button)findViewById(R.id.btn6);
        Button btn7 = (Button)findViewById(R.id.btn7);
        Button btn8 = (Button)findViewById(R.id.btn8);
        Button btn9 = (Button)findViewById(R.id.btn9);
        Button btn_eqales = (Button)findViewById(R.id.btn_eqales);
        Button btn_kakeru = (Button)findViewById(R.id.btn_kakeru);
        Button btn_mainasu = (Button)findViewById(R.id.btn_mainasu);
        Button btn_waru = (Button)findViewById(R.id.btn_pasento);
        Button btn_tasu = (Button)findViewById(R.id.btn_tasu);
        tv = (TextView)findViewById(R.id.Textview);

        btn0.setOnClickListener(v -> {
            Log.v("btnTest","btn0");
            tv.setText(setTextNum("0"));
        });

        btn1.setOnClickListener(v -> {
            Log.v("btnTest","btn1");
            tv.setText(setTextNum("1"));
        });

        btn2.setOnClickListener(v -> {
            Log.v("btnTest","btn2");
            tv.setText(setTextNum("2"));
        });

        btn3.setOnClickListener(v -> {
            Log.v("btnTest","btn3");
            tv.setText(setTextNum("3"));
        });

        btn4.setOnClickListener(v -> {
            Log.v("btnTest","btn4");
            tv.setText(setTextNum("4"));
        });

        btn5.setOnClickListener(v -> {
            Log.v("btnTest","btn5");
            tv.setText(setTextNum("5"));
        });

        btn6.setOnClickListener(v -> {
            Log.v("btnTest","btn6");
            tv.setText(setTextNum("6"));
        });

        btn7.setOnClickListener(v -> {
            Log.v("btnTest","btn7");
            tv.setText(setTextNum("7"));
        });

        btn8.setOnClickListener(v -> {
            Log.v("btnTest","btn8");
            tv.setText(setTextNum("8"));
        });

        btn9.setOnClickListener(v -> {
            Log.v("btnTest","btn9");
            tv.setText(setTextNum("9"));
        });



        btn_eqales.setOnClickListener(v -> {
            Log.v("btnTest","btn_eqales");
            int i = 0;
            int val1 = Integer.valueOf(storageNum);
            int val2 = Integer.valueOf(str);
            System.out.println(calculation);
            switch (calculation){

                case "+":
                    i = val1 + val2;
                    System.out.println("eqalesTest" + val1);
                    System.out.println("eqalesTest" + val2);
                    break;
                case "-":
                    i = val1 - val2;
                    break;
                case "/":
                    i = val1 / val2;
                    System.out.println("eqalesTest" + val1);
                    System.out.println("eqalesTest" + val2);
                    break;
                case "*":
                    i = val1 * val2;
                    System.out.println("eqalesTest" + val1);
                    System.out.println("eqalesTest" + val2);
                    break;
            }
            System.out.println("合計" + i);
            System.out.println("クラス" + Integer.toString(i).getClass().getSimpleName());
            tv.setText(Integer.toString(i));
            str = "";
            storageNum = "";
        });

        btn_kakeru.setOnClickListener(v -> {
            Log.v("btnTest","btn_kakeru");
            setCalculation("*");
        });

        btn_mainasu.setOnClickListener(v -> {
            Log.v("btnTest","btn_mainasu");
            setCalculation("-");
        });

        btn_waru.setOnClickListener(v -> {
            Log.v("btnTest","btn_waru");
            setCalculation("/");
        });

        btn_tasu.setOnClickListener(v -> {
            Log.v("btnTest","btn_tasu");
            setCalculation("+");
        });
    }

    public String setTextNum(String inputNum){
        String result = "0";
        if(str.equals("0")){
            result = inputNum;
        }else{
            result = str + inputNum;
        }
        str = result;
        return result;
    }

    public void setCalculation(String inputCalculation){
        storageNum = str;
        str = "";
        tv.setText("0");
        calculation = inputCalculation;


    }



}