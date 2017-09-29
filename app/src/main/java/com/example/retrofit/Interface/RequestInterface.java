package com.example.retrofit.Interface;

/**
 * Created by chirag.chaudhari on 12/15/2016.
 */

import com.example.retrofit.JSONResponseModel.JSONResponse;
import com.example.retrofit.Model.LoginModel;
import com.example.retrofit.Model.Page2Model;
import com.example.retrofit.Model.StudentModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RequestInterface {

    @GET("android/jsonandroid")
    Call<JSONResponse> getJSON();

    @GET("api/RetrofitAndroidObjectResponse")
    Call<StudentModel> getStudentDetails();

    @FormUrlEncoded
    @POST("api/login")
    Call<LoginModel> insertUser(
            @Field("password") String password,
            @Field("email") String email);

    @GET("api/users?page=2")
    Call<Page2Model> getObject();
}