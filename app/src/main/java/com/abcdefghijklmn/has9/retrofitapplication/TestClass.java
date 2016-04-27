package com.abcdefghijklmn.has9.retrofitapplication;

import retrofit.Call;
import retrofit.http.GET;


public interface TestClass {
    @GET("/Test/ChachingTest")
    public Call<String> secondCall2();
}
