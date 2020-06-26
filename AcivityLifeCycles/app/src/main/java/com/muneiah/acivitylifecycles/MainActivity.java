package com.muneiah.acivitylifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        f=findViewById(R.id.t1);
        f.append("Oncreate \n");
        Log.i("onCreate","App is create");
        Toast.makeText(this, "created", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        f.append("Onstart \n");
        Log.i("MainAcivity","App is started");
        Toast.makeText(this, "started", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        f.append("Onresume \n");
        Log.i("MainAcivity","App is resumed");
        Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        f.append("Onpause \n");
        Toast.makeText(this, "on paued", Toast.LENGTH_SHORT).show();
        Log.i("MainAcivity","App is paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        f.append("Onstop \n");
        Toast.makeText(this, "onstop", Toast.LENGTH_SHORT).show();
        Log.i("MainAcivity","App is stopped");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        f.append("OnreStrart \n");
        Toast.makeText(this, "restart", Toast.LENGTH_SHORT).show();
        Log.i("MainAcivity","App is restrted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        f.append("OnDestroy \n");
        Toast.makeText(this, "App Closed", Toast.LENGTH_SHORT).show();
        Log.i("MainAcivity","App is destroy");
    }
}
