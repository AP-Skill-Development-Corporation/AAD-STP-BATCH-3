package com.muneiah.hellotoast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count=0;
    TextView resultLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultLabel=findViewById(R.id.tv);
        if (savedInstanceState!=null && savedInstanceState.containsKey("key")){
            count=savedInstanceState.getInt("key");
            resultLabel.setText(""+count);
        }
    }

    public void showToastMessage(View view) {
        Toast.makeText(this, "Welcome to android App Development", Toast.LENGTH_SHORT).show();
    }

    public void increaseCount(View view) {
        count++;
        resultLabel.setText(String.valueOf(count));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key",count);
    }
}
