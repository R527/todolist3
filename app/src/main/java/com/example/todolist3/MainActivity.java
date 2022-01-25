package com.example.todolist3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.BaseAdapter;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {



    private static final String[] names = {
            "Yuka",
            "Kurumi",
            "Tomoya",
            "Mai",
            "Miki",
            "Saya",
            "Toko",
            "Nagi",
            "Yuyu",
            "Yumiko",
            "Katakuriko"
    };

    // drawableに画像を入れる、R.id.xxx はint型
    private static final int[] photos = {
            R.drawable.yuka,
            R.drawable.kurumi,
            R.drawable.tomoya,
            R.drawable.mai,
            R.drawable.miki,
            R.drawable.saya,
            R.drawable.toko,
            R.drawable.nagi,
            R.drawable.yuyu,
            R.drawable.yumiko,
            R.drawable.katakuriko
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] emails = new String[names.length];

        // nameからメルアド作成
        for(int i=0; i< names.length ;i++ ){
            emails[i] = String.format(Locale.US, "%s@mail.co.jp",names[i]);

        }

        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.listView);

        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list_items.xml を
        // activity_main.xml に inflate するためにadapterに引数として渡す
        BaseAdapter adapter = new TestAdapter(this.getApplicationContext(), R.layout.list_items,names, emails,photos);


        // ListViewにadapterをセット
        listView.setAdapter(adapter);

    }
}