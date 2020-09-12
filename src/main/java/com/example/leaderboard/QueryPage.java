package com.example.leaderboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class QueryPage extends AppCompatActivity {
    ImageButton imageButton;
    Button submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query_page);
        imageButton=findViewById(R.id.back_nav);


        final AlertDialog.Builder dialog=new AlertDialog.Builder(this,R.style.CustomAlertDialog);
        LayoutInflater inflater = LayoutInflater.from(this);
        View query_dialog =inflater.inflate(R.layout.query_dialog,null);
        final ImageButton imageButton_cancel=query_dialog.findViewById(R.id.button_cancel);
        final TextView textView_query = query_dialog.findViewById(R.id.are_you_sure);
        final Button button_yes=  query_dialog.findViewById(R.id.button_yes);


        dialog.setView(query_dialog);
        //dialog.show();
        final AlertDialog Dial =dialog.create();
        Dial.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams wmlp = Dial.getWindow().getAttributes();

        wmlp.gravity = Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL;
        wmlp.y = 350;
        Dial.show();
        Dial.getWindow().setLayout(800,700);
        imageButton_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dial.dismiss();
                final AlertDialog.Builder dialog=new AlertDialog.Builder(QueryPage.this,R.style.CustomAlertDialog2);
                LayoutInflater inflater = LayoutInflater.from(QueryPage.this);
                View failure_dialog =inflater.inflate(R.layout.failure_layout,null);
                dialog.setView(failure_dialog);
                final AlertDialog Dial =dialog.create();
                Dial.requestWindowFeature(Window.FEATURE_NO_TITLE);
                WindowManager.LayoutParams wmlp = Dial.getWindow().getAttributes();

                wmlp.gravity = Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL;
                wmlp.y = 500;
                Dial.show();
                Dial.getWindow().setLayout(800,450);
            }
        });


        button_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dial.dismiss();
                final AlertDialog.Builder dialog=new AlertDialog.Builder(QueryPage.this,R.style.CustomAlertDialog1);
                LayoutInflater inflater = LayoutInflater.from(QueryPage.this);
                View successful_dialog =inflater.inflate(R.layout.successful_layout,null);
                dialog.setView(successful_dialog);
                final AlertDialog Dial =dialog.create();
                Dial.requestWindowFeature(Window.FEATURE_NO_TITLE);
                WindowManager.LayoutParams wmlp = Dial.getWindow().getAttributes();

                wmlp.gravity = Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL;
                wmlp.y = 500;
                Dial.show();
                Dial.getWindow().setLayout(800,450);

            }
        });



        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QueryPage.this, FillForm.class);
                startActivity(intent);
            }
        });

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitProject();
            }
        });
    }


    private  void submitProject(){

        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiRequest jsonPlaceHolderApi = retrofit.create(ApiRequest.class);

        Call<List<Post>> call = jsonPlaceHolderApi.savePost(""," "," ", "");


        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"cant get anything",Toast.LENGTH_SHORT).show();

                    //textViewResult.setText("code: " + response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post: posts){

                    String content = "";
                    content += "NAME: " + post.getFirstname() + "\n";
                    content += "NAME: " + post.getLastname() + "\n";
                    content += "NAME: " + post.getEmailaddress() + "\n";
                    content += "NAME: " + post.getProjectlink() + "\n";

                   // textViewResult.append(content);

                }


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
               // textViewResult.setText(t.getMessage());
            }
        });

    }


}