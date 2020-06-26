package com.muneiah.acivitylifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    //First or Default Lifecycle Activity
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        Log.i("MainAcivity","onCreate() invoked");
        tv.append("onCreate() \n");
        Toast.makeText(this, "App is Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainAcivity","onStart() invoked");
        tv.append("onStart() \n");
        Toast.makeText(this, "App is Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainAcivity","onResume() invoked");
        tv.append("onResume() \n");
        Toast.makeText(this, "App is Resumed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainAcivity","onPause() invoked");
        tv.append("onPause() \n");
        Toast.makeText(this, "App is Paused", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainAcivity","onStop() invoked");
        tv.append("onStop()\n");
        Toast.makeText(this, "Now App is Stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainAcivity","onDestroy() invoked");
        tv.append("onDestroy()");
        Toast.makeText(this, "Now App is Destroyed", Toast.LENGTH_SHORT).show();
    }
}
