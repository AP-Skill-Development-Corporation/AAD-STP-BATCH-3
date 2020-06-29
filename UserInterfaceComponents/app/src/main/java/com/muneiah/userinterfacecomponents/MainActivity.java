package com.muneiah.userinterfacecomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RatingBar mRatingBar;
SeekBar seekBar;
TextView rating_outcome,progress_outcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String rate=String.valueOf(ratingBar.getRating());
                rating_outcome.setText(rate);
                Toast.makeText(MainActivity.this, "User Rating is :"+rate, Toast.LENGTH_SHORT).show();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBarObj, int progress, boolean fromUser) {
                String seekProgress=String.valueOf(seekBarObj.getProgress());
                progress_outcome.setText(seekProgress);
                Toast.makeText(MainActivity.this, "progress is :"+seekProgress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void init(){
        mRatingBar=findViewById(R.id.ratingBar2);
        seekBar=findViewById(R.id.seekBar);
        rating_outcome=findViewById(R.id.tv_rating);
        progress_outcome=findViewById(R.id.tv_seek);
    }
}
