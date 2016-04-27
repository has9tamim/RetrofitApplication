package com.abcdefghijklmn.has9.retrofitapplication;



import retrofit2.Call;
import retrofit2.http.GET;

public interface CallRetro {

    @GET("/AppApi/Categories/GetCategories")
    public Call<SecondModelClass> secondCall();
}

