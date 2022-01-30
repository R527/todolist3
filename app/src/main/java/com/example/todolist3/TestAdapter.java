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
import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private int layoutID;
    private List<String> tasklist;
    private List<Integer> daylist;


    static class ViewHolder {
        TextView task;
        TextView day;
    }

    TestAdapter(Context context,int itemLayoutId,
                List<String> tasks, List<Integer> days){

        inflater = LayoutInflater.from(context);
        layoutID = itemLayoutId;

        tasklist = tasks;
        daylist = days;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(layoutID, null);
            holder = new ViewHolder();
            holder.task = convertView.findViewById(R.id.task);
            holder.day = convertView.findViewById(R.id.day);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        System.out.println("position" + position);
        System.out.println("tasklist.get(position)" + tasklist.get(position));
        holder.task.setText(tasklist.get(position));

        holder.day.setText(String.valueOf(daylist.get(position)) + "日前");

        return convertView;
    }

    @Override
    public int getCount() {
        return tasklist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
