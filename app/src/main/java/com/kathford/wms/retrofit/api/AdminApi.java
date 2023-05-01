package com.kathford.wms.retrofit.api;

import com.kathford.wms.model.Admin;

import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AdminApi {

    @POST(value = "api/admin/findall")
    Call<List<Admin>> getAlldmin();

    @FormUrlEncoded
    @POST("/api/admin/signup/save")
    Call<ResponseBody> saveOrUpdateAdmin(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("address") String address,
            @Field("role") String role,
            @Field("phoneNo") String phoneNo,
            @Field("mobileNo") String mobileNo);
}
