package com.example.todolist3;

import androidx.fragment.app.DialogFragment;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class AddTaskDialogFragment extends DialogFragment {
    private final String TAG = "AddTaskDialogFragment";
    private TaskListViewModel mTaskListViewModel;
    private final CompositeDisposable mDisposable = new CompositeDisposable();
    public interface AddTaskDialogListener{
        public void onDialogPositiveClick(String value);
    }

    private AddTaskDialogListener listener;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTaskListViewModel = new ViewModelProvider(this).get(TaskListViewModel.class);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener = (AddTaskDialogListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement NoticeDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //ダイヤログのレイアウト適応
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.add_task_daialog,null));

        builder.setMessage("タスクの追加")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d(TAG,"OK was clicked");
                        EditText editText = (EditText)getDialog().findViewById(R.id.task_text);

                        if (editText != null) {

                            //タスク追加処理
                            mDisposable.add(mTaskListViewModel.insertTask(editText.getText().toString())
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(() -> {},
                                            throwable -> Log.e(TAG, "Unable to update username", throwable)));
                        } else {
                            //例外
                            Log.e(TAG, "EditText not found!");
                        }
//                        if(editText != null){
//                            listener.onDialogPositiveClick(editText.getText().toString());
//                        }else{
//                            Log.e("","EditText not found!");
//                        }
                    }
                })
                .setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
