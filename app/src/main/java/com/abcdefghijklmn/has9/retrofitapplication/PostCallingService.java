package com.abcdefghijklmn.has9.retrofitapplication;

import java.util.HashMap;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;


public interface PostCallingService {
    @POST("/CustomerAccess/Login/")
    Call<PostModelClass> postCall(@Body HashMap<String, String> rasel);
}
