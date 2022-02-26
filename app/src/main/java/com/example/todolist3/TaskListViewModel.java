package com.example.todolist3;

import android.app.Application;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public class TaskListViewModel extends AndroidViewModel {
    private final String TAG = "TaskViewModel";
    private AccessTimeDao accessTimeDao;
    private List<TaskEntity> mTasks;


    //コンストラクター
    public TaskListViewModel(@NonNull Application application){
        super(application);
        //applicationとは
        //このアプリの中に一つしかないクラス
        //アプリ共通のコンポーネントをここから引き出す
        accessTimeDao = ((AppComponent)application).getDatabase().accessTimeDao();
    }

    //非同期処理対応の返り値
    //メソッド内にバージョン不足だと利用できないメソッドあるから注意書きの@RequiresApi
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Flowable<List<String>> getTaskTextList() {
        //tasksを全取得して
        return accessTimeDao.getAll()
                //DatabaseにあるTasks＜List＞を取得していじる
                .map(tasks -> {
                    mTasks = tasks;
                    return tasks.stream()
                            //Stringのみを抽出
                            //for文で回すのと同じ処理
                            .map(task -> task.getTaskText())
                            .collect(Collectors.toList());
                });
    }


    //タスクを追加する処理
    public Completable insertTask(final String text) {
        Log.d(TAG,text);
        //Entityに登録
        TaskEntity task = new TaskEntity();
        task.setTaskText(text);
        //データベースに登録
        return accessTimeDao.insert(task);
    }

    //タスク削除処理
    public Completable deleteTask(int position) {
        return accessTimeDao.delete(mTasks.get(position));
    }
}
