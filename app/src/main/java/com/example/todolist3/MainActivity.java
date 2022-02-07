package com.example.todolist3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity implements AddTaskDialogFragment.AddTaskDialogListener{

    private TaskModel taskModel;
    private TestAdapter testAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskModel = new TaskModel();

        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.listView);
        testAdapter = new TestAdapter(this.getApplicationContext(),R.layout.list_items,taskModel);
        listView.setAdapter(testAdapter);

        //タスク追加ボタン
        FloatingActionButton button = (FloatingActionButton)findViewById(R.id.add_task_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialog = new AddTaskDialogFragment();
                dialog.show(getSupportFragmentManager(),"AddTaskDialogFragment");
            }
        });


    }

    @Override
    public void onDialogPositiveClick(String value) {
        taskModel.addTask(value);
        testAdapter.notifyDataSetChanged();
    }
}