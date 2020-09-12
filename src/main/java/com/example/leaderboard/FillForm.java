package com.example.leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class FillForm extends AppCompatActivity {
    ImageButton imageButton;
    EditText editText_firstName, editText_lastName, editText_emailAddress, editText_githubLink;
    Button button_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form);

        imageButton= findViewById(R.id.back_nav);
        editText_firstName= findViewById(R.id.first_name);
        editText_lastName= findViewById(R.id.last_name);
        editText_emailAddress= findViewById(R.id.email_address);
        editText_githubLink= findViewById(R.id.project_github);
        button_submit= findViewById(R.id.submit_btn);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FillForm.this,RecyclerView.class);
                startActivity(intent);
            }
        });

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FillForm.this,QueryPage.class);
                startActivity(intent);

            }
        });

    }


}