package com.example.todolist3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface AccessTimeDao {

    @Query("SELECT * FROM taskentity")
    Flowable<List<TaskEntity>> getAll();

    @Query("SELECT * FROM taskentity WHERE id IN (:ids)")
    Flowable<List<TaskEntity>> loadAllByIds(int[] ids);
    @Insert
    Completable insertAll(TaskEntity... accessTimes);

    @Insert
    Completable insert(TaskEntity accessTime);

    @Delete
    Completable delete(TaskEntity accessTime);

}



