package com.example.todolist3;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
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
    }

    public void deleteTask(int id){
        this.tasks.remove(id - 1);
    }
}
