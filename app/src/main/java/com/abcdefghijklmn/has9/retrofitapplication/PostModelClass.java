package com.abcdefghijklmn.has9.retrofitapplication;

import com.google.gson.annotations.SerializedName;


public class PostModelClass {
    @SerializedName("Name")
    String nameForPostMethod;

    public String getNameForPostMethod() {
        return nameForPostMethod;
    }
}
