package com.muneiah.servicesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.img);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c==0) {
                    Intent i = new Intent(MainActivity.this, MyService.class);
                    startService(i);
                    c++;
                    iv.setImageResource(R.drawable.ic_stop_black_24dp);
                }else {
                    iv.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    Intent i = new Intent(MainActivity.this, MyService.class);
                    stopService(i);
                    c--;
                }
            }
        });
    }
}
