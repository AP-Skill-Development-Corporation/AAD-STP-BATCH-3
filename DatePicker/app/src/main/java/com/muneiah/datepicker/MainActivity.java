package com.muneiah.datepicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button d,t;
int myyear,mymonth,myday;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d=findViewById(R.id.datepicker_button);
        t=findViewById(R.id.timePicker_button);
        textView=findViewById(R.id.date_tv);
        d.setOnClickListener(this);
        t.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.datepicker_button:
                openDatePicker();
                break;
            case R.id.timePicker_button:
                opentimePicker();
                break;
        }
    }

    private void opentimePicker() {
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void openDatePicker() {
        final Calendar c=Calendar.getInstance();
        myday=c.get(Calendar.DAY_OF_MONTH);
        mymonth=c.get(Calendar.MONTH);
        myyear=c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
              //  String date=String.valueOf(dayOfMonth+"/"+(month+1)+"/"+year);
                textView.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
            }
        },myyear,mymonth,myday);
        datePickerDialog.show();
    }
}
