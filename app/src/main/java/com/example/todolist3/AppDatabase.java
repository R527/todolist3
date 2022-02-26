package com.example.todolist3;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TaskEntity.class},version = 1,exportSchema =  false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AccessTimeDao accessTimeDao();
    private static AppDatabase sInstance;
    public static final String DATABASE_NAME = "mydb";

    public static AppDatabase getInstance(final Context context) {
        //二つ以上あると問題だから制御する
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return sInstance;
    }
}
