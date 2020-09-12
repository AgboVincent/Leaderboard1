package com.example.leaderboard.Model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.leaderboard.ApiRequest;
import com.example.leaderboard.Post;
import com.example.leaderboard.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        textViewResult = findViewById(R.id.text_view_result);

        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiRequest jsonPlaceHolderApi = retrofit.create(ApiRequest.class);

        Call<List<Post>> call = jsonPlaceHolderApi.savePost(""," "," ", "");


        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {

                    textViewResult.setText("code: " + response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post: posts){

                    String content = "";
                    content += "NAME: " + post.getFirstname() + "\n";
                    content += "NAME: " + post.getLastname() + "\n";
                    content += "NAME: " + post.getEmailaddress() + "\n";
                    content += "NAME: " + post.getProjectlink() + "\n";

                    textViewResult.append(content);

                }


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }



}