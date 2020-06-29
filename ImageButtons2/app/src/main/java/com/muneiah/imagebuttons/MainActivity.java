package com.muneiah.imagebuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.myimage);
       img.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               img.setImageResource(R.drawable.image_colors);
           }
       });
    }
}
