package com.muneiah.retrofitdemo_on_covid19api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPointInterface
{
    @GET("/dayone/country/IN")
    Call<String> getData();
}
