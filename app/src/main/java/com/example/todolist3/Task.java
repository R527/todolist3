package com.example.todolist3;

public class Task {
    private int id;
    private String text;

    public Task(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return this.id;
    }

    public String getTask() {
        return this.text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTask(String text) {
        this.text = text;
    }

}