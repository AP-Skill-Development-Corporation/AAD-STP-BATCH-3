package com.muneiah.retrofitdemo_on_covid19api;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitInstance {
    public static final String BASE_URL="https://api.covid19api.com/";
    private static Retrofit retrofit;

    public static Retrofit getInsatnce(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
