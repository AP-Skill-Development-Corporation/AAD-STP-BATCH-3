package com.muneiah.myinputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, mobil, emailAddress;
    TextView tv;
    RadioButton m, f;
    SeekBar seekBar;
    RatingBar ratingBar;
    CheckBox j, p, cLang;
    Spinner spinner;
    String gender, launuage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.et_username);
        mobil = findViewById(R.id.et_mobilnumber);
        emailAddress = findViewById(R.id.et_email);
        tv = findViewById(R.id.tv_text);
        m = findViewById(R.id.male);
        f = findViewById(R.id.female);
        seekBar = findViewById(R.id.seek);
        ratingBar = findViewById(R.id.rating);
        spinner = findViewById(R.id.spin);
        j = findViewById(R.id.java);
        p = findViewById(R.id.python);
        cLang = findViewById(R.id.c);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar1, int progress, boolean fromUser) {
                String pr = String.valueOf(seekBar1.getProgress());
                tv.setText(pr);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String rate = String.valueOf(ratingBar.getRating());
                tv.setText(rate);
            }
        });
    }

    public void submitValues(View view) {
        String myname = name.getText().toString();
        String mymobil = mobil.getText().toString();
        String myemail = emailAddress.getText().toString();
        String mybranch = spinner.getSelectedItem().toString();
        if (m.isChecked()){
            gender="Male";
        }else {
            gender="Female";
        }
        if (j.isChecked()){
            launuage="Java ";
        }if (cLang.isChecked()){
            launuage=launuage+"C "+"\t\t";

        }if (p.isChecked()){
            launuage=launuage+"Python"+"\t\t";
        }

        if (myname.isEmpty() | mymobil.isEmpty() | myemail.isEmpty()) {
            Toast.makeText(this, "please add details", Toast.LENGTH_SHORT).show();
        } else {

            tv.setText(myname + "\n" +
                    mymobil + "\n" +
                    myemail + "\n"
                    + mybranch+"\n"+
                    gender+"\n"+launuage);
        }
        name.setText("");
    }
}
