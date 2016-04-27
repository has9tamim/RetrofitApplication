package com.abcdefghijklmn.has9.retrofitapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SecondModelClass {
    @SerializedName("Categories")
    List<ClassForCategories> classForCategories;

    public List<ClassForCategories> getClassForCategories() {
        return classForCategories;
    }
}
