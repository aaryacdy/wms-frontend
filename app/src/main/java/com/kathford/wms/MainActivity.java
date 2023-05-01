package com.kathford.wms;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kathford.wms.retrofit.RetrofitService;
import com.kathford.wms.retrofit.api.AdminApi;

import okhttp3.Call;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView();
    }


 /*   Call<ResponseBody> call = ad.submitForm("John Doe", "johndoe@example.com", "Hello, world!");
call.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            // Handle success
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            // Handle error
        }
    });*/


}
