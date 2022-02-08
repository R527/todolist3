package com.example.todolist3;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.PreferencesFactory;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class TaskModel extends AppCompatActivity {
    private List<Task> tasks;
    private Context context;

    public TaskModel(){
        this.tasks = new ArrayList<Task>();
    }

    public List<Task> getAllTask(){
        return this.tasks;
    }

    public void addTask(String text){
        this.tasks.add(new Task(tasks.size() + 1,text));

        SharedPreferences pfs = context.getSharedPreferences("TaskData",MODE_PRIVATE);
        Editor editor = pfs.edit();
        editor.putString("task" + tasks.size() + 1,text);
        editor.apply();
    }

    public void deleteTask(int id){
        this.tasks.remove(id - 1);
    }
}
