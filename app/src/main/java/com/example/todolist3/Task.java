package com.example.todolist3;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Task extends AppCompatActivity {

    public String task;
    public int id;

    Task(String task,int id){
        this.id = id;
        this.task = task;
    }

    public int getid(){
        return this.id;
    }

    public void setid(int id){
        this.id = id;
    }

    public String getTask(){
        return this.task;
    }

    public void setTask(String task){
        this.task = task;
    }
}