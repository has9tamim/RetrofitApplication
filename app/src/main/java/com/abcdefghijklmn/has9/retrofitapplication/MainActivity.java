package com.abcdefghijklmn.has9.retrofitapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.firstOne)
    TextView textView;
    @InjectView(R.id.firstTwo)
    ImageView textView2;
    @InjectView(R.id.firstThree)
    ImageView textView3;
    @InjectView(R.id.firstfour)
    ImageView textView4;
    @InjectView(R.id.firstfive)
    ImageView textView5;

    String BASE_URL = "http://api.ajkerdeal.com";

    String BASE_URL_TWO = "http://192.168.0.139";
    CallingService callingService;
    CallRetro callRetro;
    PostCallingService postCallingService;
    TestClass testClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inject the view with layout
        ButterKnife.inject(this);

        //retrofit is start from hear
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl(BASE_URL_TWO)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//-----------------Calling Portion(Response)--------------
        testClass = retrofit.create(TestClass.class);
        Call<String> callForString = testClass.secondCall2();
        callForString.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
                textView.setText(response.body());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


        callingService = retrofit.create(CallingService.class);
        callRetro = retrofit.create(CallRetro.class);

        postCallingService = retrofit.create(PostCallingService.class);
        HashMap<String, String> dicMap = new HashMap<String, String>();
        dicMap.put("Email", "kazal.k1@gmail.com");
        dicMap.put("Password", "123");
        Call<PostModelClass> postModelClassCall = postCallingService.postCall(dicMap);
        postModelClassCall.enqueue(new Callback<PostModelClass>() {
            @Override
            public void onResponse(Response<PostModelClass> response, Retrofit retrofit) {
                //Toast.makeText(getBaseContext(), response.body().getNameForPostMethod(), Toast.LENGTH_LONG).show();
                //  textView.setText(response.body().getNameForPostMethod());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
/*
        Call<SecondModelClass> callForSecondTime = (Call<SecondModelClass>) callRetro.secondCall();
        callForSecondTime.enqueue(new Callback<SecondModelClass>() {
            @Override
            public void onResponse(Response<SecondModelClass> response, Retrofit retrofit) {


                Toast.makeText(getBaseContext(), response.body().getClassForCategories().get(0).categoryName, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });*/


        Call<List<ModelClass>> call = callingService.getDataFromApi();
        call.enqueue(new Callback<List<ModelClass>>() {


            @Override
            public void onResponse(Response<List<ModelClass>> response, Retrofit retrofit) {

                setImage(response, 0, textView5);
                setImage(response, 1, textView2);
                setImage(response, 2, textView3);
                setImage(response, 3, textView4);

            }

            void setImage(Response<List<ModelClass>> response, int location, ImageView imageView) {

                Picasso.with(getBaseContext()).load(response.body().get(location).getName()).into(imageView);
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getBaseContext(), t.toString(), Toast.LENGTH_LONG).show();

                Log.e("error", t.toString());
            }
        });

    }


}
