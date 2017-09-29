package com.example.retrofit.Interface;

import com.example.retrofit.Model.StudentModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by chirag.chaudhari on 12/15/2016.
 */

public interface RetrofitObjectAPI {
    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of student.
    */
    @GET("api/RetrofitAndroidObjectResponse")
    Call<StudentModel> getStudentDetails();
}
