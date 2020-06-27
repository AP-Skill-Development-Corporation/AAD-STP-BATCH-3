package com.muneiah.rotationsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.github.nisrulz.sensey.RotationAngleDetector;
import com.github.nisrulz.sensey.Sensey;

public class MainActivity extends AppCompatActivity {
ToggleButton toggleButton;
TextView tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton=findViewById(R.id.tg);
        tt=findViewById(R.id.tv);
        Sensey.getInstance().init(this);
        final RotationAngleDetector.RotationAngleListener rotationAngleListener=new RotationAngleDetector.RotationAngleListener() {
            @Override
            public void onRotation(float v, float v1, float v2) {
                tt.setText(String.valueOf(v+"\n"+v1+"\n"+v2));
            }
        };
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                        Sensey.getInstance().startRotationAngleDetection(rotationAngleListener);
                    Toast.makeText(MainActivity.this, "On state", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "of state", Toast.LENGTH_SHORT).show();
                    Sensey.getInstance().stopRotationAngleDetection(rotationAngleListener);
                }
            }
        });
    }
}
