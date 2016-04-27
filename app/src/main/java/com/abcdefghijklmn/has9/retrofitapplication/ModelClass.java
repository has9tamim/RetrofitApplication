package com.abcdefghijklmn.has9.retrofitapplication;

import com.google.gson.annotations.SerializedName;

public class ModelClass {
    @SerializedName("ImageLink")
    String name;

    public String getName() {
        return name;
    }
}
