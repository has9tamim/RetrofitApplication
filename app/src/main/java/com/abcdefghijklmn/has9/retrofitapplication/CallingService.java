package com.abcdefghijklmn.has9.retrofitapplication;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;


public interface CallingService {
    @GET("/Banner/AppBanner")
    public Call<List<ModelClass>> getDataFromApi();
}