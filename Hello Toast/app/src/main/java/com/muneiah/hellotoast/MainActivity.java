package com.muneiah.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    }

    public void showToastMessage(View view) {
        Toast.makeText(this, "Welcome to android App Development", Toast.LENGTH_SHORT).show();
    }

    public void increaseCount(View view) {
        count++;
        resultLabel.setText(String.valueOf(count));
    }
}
