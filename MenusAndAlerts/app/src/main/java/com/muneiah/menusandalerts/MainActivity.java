package com.muneiah.menusandalerts;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button datePicker,timePicker;
int m,d,y;
TextView date_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker=findViewById(R.id.datePicker_button);  //crl+d for duplicate entire line
        timePicker=findViewById(R.id.timePicker_button);  //crl+d for duplicate entire line
        /*for delete entire line shift + delete*/
        date_result=findViewById(R.id.tv);
        datePicker.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menus,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.alert:
                showAlert();
                Toast.makeText(this, "alert item ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.org:
                Toast.makeText(this, "Ap Skill development corporation ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                Toast.makeText(this, "search item", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showAlert(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Are you sure?");
        builder.setMessage("Do you want to close the app..");
        builder.setIcon(R.drawable.ic_warning_black_24dp);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Bye..", Toast.LENGTH_SHORT).show();
                dialog.cancel();
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();



    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        final Calendar c=Calendar.getInstance();
        d=c.get(Calendar.DAY_OF_MONTH);
        m=c.get(Calendar.MONTH);
        y=c.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date=year+"-"+(month+1)+"-"+dayOfMonth;
                date_result.setText(date);
                Toast.makeText(MainActivity.this, "Date is: "+date, Toast.LENGTH_SHORT).show();
            }
        },y,m,d);
        datePickerDialog.show();
    }
}
