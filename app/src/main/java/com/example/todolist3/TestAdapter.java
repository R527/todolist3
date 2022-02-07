package com.example.todolist3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends BaseAdapter {


    private final String debugTag = "TaskAdapter";

    private LayoutInflater inflater;
    private int itemLayoutId;
    private TaskModel taskModel;

    TestAdapter(Context context, int itemLayoutId, TaskModel model) {
        super();
        this.inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemLayoutId = itemLayoutId;
        this.taskModel = model;
    }


    @Override
    public int getCount() {
        return taskModel.getAllTask().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        List<Task> tasks = taskModel.getAllTask();

        TextView taskTextView;
        Button deleteTaskButton;

        convertView = inflater.inflate(itemLayoutId, parent, false);
        // ViewHolder を生成
        taskTextView = convertView.findViewById(R.id.task_text);
        deleteTaskButton = convertView.findViewById(R.id.delete_btn);
        deleteTaskButton.setTag(tasks.get(position).getId());
        deleteTaskButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                taskModel.deleteTask((int)v.getTag());
                notifyDataSetChanged();
            }
        });

        taskTextView.setText(tasks.get(position).getTask());

        return convertView;
    }
}
