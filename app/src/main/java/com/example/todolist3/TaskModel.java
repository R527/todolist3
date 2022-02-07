package com.example.todolist3;

import java.util.ArrayList;
import java.util.List;

public class TaskModel {
    private List<Task> tasks;

    public TaskModel(){
        this.tasks = new ArrayList<Task>();
    }

    public List<Task> getAllTask(){
        return this.tasks;
    }

    public void addTask(String text){
        //すでに登録されているタスクのidのうち最も大きいものを取得する。
        int currentMaxId = 0;
        for(Task task : this.tasks) {
            if(task.getId() > currentMaxId) {
                currentMaxId = task.getId();
            }
        }

        //それに1を足したものを新規idとする。
        this.tasks.add(new Task(currentMaxId + 1,text));
    }

    public void deleteTask(int id){
        this.tasks.remove(id);
    }
}
