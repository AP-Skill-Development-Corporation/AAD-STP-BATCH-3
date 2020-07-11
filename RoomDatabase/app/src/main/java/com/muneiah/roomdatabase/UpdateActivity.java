package com.muneiah.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
EditText updateName,updateRoll;
Student_Entity entity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        updateName=findViewById(R.id.update_name);
        updateRoll=findViewById(R.id.update_rollnumber);
        Intent i=getIntent();
        String n=i.getStringExtra("name");
       String r= i.getStringExtra("roll");
       updateName.setText(n);
       updateRoll.setText(r);
       updateRoll.setKeyListener(null);


    }

    public void updateData(View view) {
        String updatedName=updateName.getText().toString();
        String updatedRoll=updateRoll.getText().toString();
        entity=new Student_Entity();
        entity.setRollNumber(updatedRoll);
        entity.setName(updatedName);
       // MainActivity.dataBase.studentDAO().updateData(entity);//normal db
        //live db
        MainActivity.myViewModel.update(entity);
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);


    }
}
