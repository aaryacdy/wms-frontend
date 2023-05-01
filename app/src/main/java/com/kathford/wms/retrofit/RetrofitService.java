package com.kathford.wms.retrofit;

import com.google.gson.Gson;
import com.kathford.wms.retrofit.api.AdminApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private Retrofit retrofit;

    public RetrofitService() {
        initializeRetrofit();
    }

    public void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("localhost:8080/wms")
//                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    AdminApi adminApi = retrofit.create(AdminApi.class);
}
