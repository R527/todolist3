package com.example.todolist3;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {AccessTime.class},version = 1,exportSchema =  false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AccessTimeDao accessTimeDao();
}
