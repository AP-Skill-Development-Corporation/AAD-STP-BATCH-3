package com.muneiah.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rec;
    int img[];
    String titles[];
MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec = findViewById(R.id.myrecyclerview);
        titles = getResources().getStringArray(R.array.movieTitles);
        img = new int[]{R.drawable.aa,
                R.drawable.bahubali,
                R.drawable.chirutha,
                R.drawable.dookudu,
                R.drawable.eega,
                R.drawable.fidha,
                R.drawable.gabbarsingh,
                R.drawable.hello,
                R.drawable.i,
                R.drawable.jayam};
        adapter=new MyAdapter(this,titles,img);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter);
    }
    //file>project stracture>dependancys>app>right (+)>Lib dependancy>search the recyclervirew>ok>ok
}
