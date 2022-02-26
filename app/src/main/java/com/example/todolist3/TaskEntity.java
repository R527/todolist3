package com.example.todolist3;


import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TaskEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "access_time")
    private String taskText;

//    public TaskEntity(String accessTime){
//        this.taskText = accessTime;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTaskText(String accessTime) {
        this.taskText = accessTime;
    }

    public String getTaskText() {
        return taskText;
    }
}
