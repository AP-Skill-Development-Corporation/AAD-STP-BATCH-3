package com.muneiah.dateandtimepickers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
TextView tv;
Button btn_timePicker;
int day,month,year,hour,min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv_result);
        btn_timePicker=findViewById(R.id.timePicker_btn);
        btn_timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c=Calendar.getInstance();
                hour=c.get(Calendar.HOUR_OF_DAY);
                min=c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String time=hourOfDay+"-"+minute;
                        tv.setText(time);
                    }
                },hour,min,false);
                timePickerDialog.show();


            }
        });
    }

    public void showDatePicker(View view)
    {
        final Calendar c=Calendar.getInstance();
        day=c.get(Calendar.DAY_OF_MONTH);
        month=c.get(Calendar.MONTH);
        year=c.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
            {
                String date=year+"-"+(month+1)+"-"+dayOfMonth;
                tv.setText(date);
            }
        },year,month,day);
        datePickerDialog.show();

    }
}
