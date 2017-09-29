package com.example.retrofit.Activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.retrofit.Adapter.DataAdapter;
import com.example.retrofit.Interface.RequestInterface;
import com.example.retrofit.JSONResponseModel.JSONResponse;
import com.example.retrofit.Model.AndroidVersion;
import com.example.retrofit.Model.LoginModel;
import com.example.retrofit.Model.Page2Model;
import com.example.retrofit.Model.StudentModel;
import com.example.retrofit.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<AndroidVersion> data;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getResponseRetrofit();
       // getLoginRetrofit();
        // initViews();
    }
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
       // loadJSONArray();

       // getRetrofitObject();

      //  getLoginRetrofit();

    }
    private void loadJSONArray(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.learn2crack.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = request.getJSON();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter = new DataAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

                Log.e("Error",t.getMessage());

            }


        });
    }

    void getRetrofitObject() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface service = retrofit.create(RequestInterface.class);

        Call<StudentModel> call1 = service.getStudentDetails();

        call1.enqueue(new Callback<StudentModel>() {
            @Override
            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                try {

                    Log.e("StudentId  :  ","" + response.body().getStudentId());
                    Log.e("StudentName  : "," " + response.body().getStudentName());
                    Log.e("StudentMarks  : "," " + response.body().getStudentMarks());

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<StudentModel> call, Throwable t) {

            }

        });
    }


    //Post Request
    void getLoginRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface service = retrofit.create(RequestInterface.class);

        Call<LoginModel> call1 = service.insertUser("cityslicka","chirag@gmail");

        call1.enqueue(new Callback<LoginModel>() {


            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                System.out.println("Response status code: " + response.code());

                if (!response.isSuccess()) {
                    // print response body if unsuccessful
                    try {
                        System.out.println(response.errorBody().string());
                    } catch (IOException e) {
                        // do nothing
                    }
                    return;
                }else {

                    Log.e("success", "success");
                    Log.e("token", "" + response.body().getToken());
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                System.out.println("onFailure");
                System.out.println(t.getMessage());
            }
        });

    }

    /**
     * Get Request
     *{
     "page": "2",
     "per_page": 3,
     "total": 12,
     "total_pages": 4,
     "data": [
     {
     "id": 4,
     "first_name": "eve",
     "last_name": "holt",
     "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"
     },
     {
     "id": 5,
     "first_name": "gob",
     "last_name": "bluth",
     "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg"
     },
     {
     "id": 6,
     "first_name": "tracey",
     "last_name": "bluth",
     "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg"
     }
     ]
     }
     */
    void getResponseRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface service = retrofit.create(RequestInterface.class);

        Call<Page2Model> call1 = service.getObject();

        call1.enqueue(new Callback<Page2Model>() {


            @Override
            public void onResponse(Call<Page2Model> call, Response<Page2Model> response) {
                if (!response.isSuccess()) {
                    // print response body if unsuccessful
                    try {
                        System.out.println(response.errorBody().string());
                    } catch (IOException e) {
                        // do nothing
                    }
                    return;
                }else {

                    Log.e("success", "success");
                    Log.e("page", ""+response.body().getPage());
                    Log.e("total", "success"+response.body().getTotal());
                    System.out.println(response.body().data.size());

                }
            }

            @Override
            public void onFailure(Call<Page2Model> call, Throwable t) {

            }
        });

   }



}