package com.muneiah.retrofitdemo_on_covid19api;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView activeCases,deathCases,date_text,recoveredCases,conformedCases;
ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activeCases=findViewById(R.id.active_tv);
        deathCases=findViewById(R.id.deaths_tv);
        date_text=findViewById(R.id.date_tv);
        recoveredCases=findViewById(R.id.recovered_tv);
        conformedCases=findViewById(R.id.conformed_tv);
        pd=new ProgressDialog(this);
        pd.setTitle("Data Fetching ..From Internet");
        pd.setMessage("Please wait ..Loading..");
        pd.show();
        EndPointInterface endPointInterface=RetrofitInstance.getInsatnce().create(EndPointInterface.class);
        Call<String> c=endPointInterface.getData();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                pd.dismiss();
                //Toast.makeText(MainActivity.this, ""+response.body().toString(), Toast.LENGTH_SHORT).show();
                try {
                    JSONArray rootarry=new JSONArray(response.body());
                      for(int i=0;i<rootarry.length();i++){
                          JSONObject rootObj=rootarry.getJSONObject(i);
                          String cnf=rootObj.getString("Confirmed");
                          String deaths=rootObj.getString("Deaths");
                          String rec=rootObj.getString("Recovered");
                          String act=rootObj.getString("Active");
                          String dt=rootObj.getString("Date");
                          date_text.setText("Date :"+forDateFormat(dt));
                          activeCases.setText("Activie Cases  :"+act);
                          conformedCases.setText("Conformed Cases :"+cnf);
                          recoveredCases.setText("Recovered :"+rec);
                          deathCases.setText("Deaths :"+deaths);

                      }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something Went Wrong with get data..", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private String forDateFormat(String dt) {
        String inputPattern="yy-mm-dd";
        String outputPattern="dd-mm-yy";

        SimpleDateFormat inputFormat=new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat=new SimpleDateFormat(outputPattern);
        Date d=null;
        String str=null;
        try {
            d=inputFormat.parse(dt);
            str=outputFormat.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;

    }
}
/*https://api.covid19api.com/dayone/country/IN*/