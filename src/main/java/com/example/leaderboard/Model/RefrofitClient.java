package com.example.leaderboard.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RefrofitClient {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://docs.google.com/forms/d/e/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
