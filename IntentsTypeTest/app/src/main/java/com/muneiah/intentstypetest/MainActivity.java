package com.muneiah.intentstypetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    /*For Declare the View Components Edittext and Button*/
EditText et,et2;
Button btn;
public static final String KEY="apssdc.in";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Inisilize the View through its id's */
        et=findViewById(R.id.et_user_input);
        et2=findViewById(R.id.et_web_input);
        btn=findViewById(R.id.webButton);
        /*Another type of View Event Handiling by using view object*/
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String input=et2.getText().toString();
               Uri uri=Uri.parse("https://www."+input+".com");
               Intent myintent=new Intent(Intent.ACTION_VIEW,uri);
               startActivity(myintent);
           }
       });
    }
        /*When the Second Button Event Handiling (Through xml onClick() Listener )*/
    public void show_secondActivity(View view) {
        String data=et.getText().toString();
        Intent int_obj=new Intent(this,SecondActivity.class);
        int_obj.putExtra(KEY,data);
        startActivity(int_obj);
    }
}
