package com.example.todolist3;

import android.app.Application;

import com.example.todolist3.AppDatabase;

class AppComponent extends Application {
    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this);
    }
}
