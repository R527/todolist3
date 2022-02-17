package com.example.todolist3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.ref.WeakReference;
import java.sql.Timestamp;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AddTaskDialogFragment.AddTaskDialogListener{

    private TaskModel taskModel;
    private TestAdapter testAdapter;
    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskModel = new TaskModel();
        database = AppDatabaseSingleton.getInstace(getApplicationContext());


        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.listView);
        testAdapter = new TestAdapter(this.getApplicationContext(),R.layout.list_items,taskModel);
        listView.setAdapter(testAdapter);


        //タスク追加ボタン
        FloatingActionButton button = (FloatingActionButton)findViewById(R.id.add_task_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialog = new AddTaskDialogFragment();
                dialog.show(getSupportFragmentManager(),"AddTaskDialogFragment");
            }
        });
    }

    @Override
    public void onDialogPositiveClick(String value) {
        Log.d("Main",value);
        taskModel.addTask(value);
        new ButtonClickListenr(this,database,value);
        testAdapter.notifyDataSetChanged();
    }

    private class ButtonClickListenr implements View.OnClickListener{

        private Activity activity;
        private AppDatabase database;
        private String value;

        public ButtonClickListenr(Activity activity, AppDatabase database, String value) {
            Log.d("MainActivity","ButtonClickListenr");
            this.activity = activity;
            this.database = database;
            this.value = value;
        }

        @Override
        public void onClick(View v) {
            Log.d("MainActivity","onClick");
            new DataStoreAsyncTask(database, activity, value).execute();
        }
    }

    private static class DataStoreAsyncTask extends AsyncTask<Void,Void,Integer> {
        private WeakReference<Activity> weakActivity;
        private AppDatabase database;
        private String value;

        public DataStoreAsyncTask(AppDatabase database, Activity activity, String value){
            Log.d("MainActivity","DataStoreAsyncTask");
            this.database = database;
            weakActivity = new WeakReference<>(activity);
            this.value = value;
        }

        @Override
        protected Integer doInBackground(Void...params){
            Log.d("MainActivity","doInBackground");
            AccessTimeDao accessTimeDao = (AccessTimeDao) database.accessTimeDao();
            accessTimeDao.insert(new AccessTime(value));
            Log.d("MainActivity",value);
            return 0;
        }

        @Override
        protected void onPostExecute(Integer code){
            Log.d("MainActivity","onPostExecute");
            Activity activity = weakActivity.get();
            if(activity == null){
                return;
            }
        }
    }

}