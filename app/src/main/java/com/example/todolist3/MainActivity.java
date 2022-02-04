package com.example.todolist3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.BaseAdapter;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;
import android.widget.Button;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private List<Task> taskList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> tasks = new ArrayList<>();
        List<Integer> days = new ArrayList<>();



        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.listView);
        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list_items.xml を
        // activity_main.xml に inflate するためにadapterに引数として渡す
        BaseAdapter adapter = new TestAdapter(this.getApplicationContext(), R.layout.list_items,tasks,days);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

        //btnの設定
        Button addTaskBtn = findViewById(R.id.add_task_btn);
        addTaskBtn.setOnClickListener(v -> {
            tasks.add("test");
            days.add(1);
            Log.v("setOnClickListener","test");
           // ListViewにadapterをセット
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        });
//        setContentView(R.layout.activity_main);
    }
}