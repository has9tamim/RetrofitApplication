package com.abcdefghijklmn.has9.retrofitapplication;

import com.google.gson.annotations.SerializedName;


public class ClassForCategories {

    @SerializedName("CategoryName")
    String categoryName;

    public String getCategoryName() {
        return categoryName;
    }
}
