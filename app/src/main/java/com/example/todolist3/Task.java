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
    public int day;

    Task(String task,int day){
        this.day = day;
        this.task = task;
    }

    public int getDay(){
        return this.day;
    }

    public void setDay(int day){
        this.day = day;
    }

    public String getTask(){
        return this.task;
    }

    public void setTask(String task){
        this.task = task;
    }
}