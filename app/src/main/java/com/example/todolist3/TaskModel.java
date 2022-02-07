package com.example.todolist3;

import java.util.ArrayList;
import java.util.List;

public class TaskModel {
    private List<Task> tasks;

    public void  TaskModel(){
        this.tasks = new ArrayList<Task>();
    }

    public List<Task> getAllTask(){
        return this.tasks;
    }

    public void addTask(String text){
        this.tasks.add(new Task(text,tasks.size() + 1));
    }

    public void deleteTask(int id){
        this.tasks.remove(id);
    }
}
