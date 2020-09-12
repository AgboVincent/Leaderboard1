package com.example.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecyclerView extends AppCompatActivity   {
  PagerAdapter adapterViewPager;
  Button submit_button;
   androidx.recyclerview.widget.RecyclerView recyclerView;

    List<Get> list;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        list = new ArrayList<Get>();

        recyclerView= this. findViewById(R.id.recycler_view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerView.this));

        adapter = new Adapter (RecyclerView.this,list);
        recyclerView.setAdapter(adapter);

        submit_button = findViewById(R.id.button_submit);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerView.this,FillForm.class);
                startActivity(intent);
            }
        });

        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Learning Leaders"));
        tabLayout.addTab(tabLayout.newTab().setText("Skill IQ Leaders"));
        tabLayout.toString().toLowerCase();
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        vpPager.setAdapter(adapterViewPager);
        vpPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

       /* PagerTabStrip pagerTabStrip = (PagerTabStrip) findViewById(R.id.pager_header);
        pagerTabStrip.setDrawFullUnderline(true);
        */

        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Get>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Get>>() {
            @Override
            public void onResponse(Call<List<Get>> call, Response<List<Get>> response) {

                recyclerView.setAdapter(new Adapter(getApplicationContext(),response.body()));

               /* if (!response.isSuccessful()) {

                    textViewResult.setText("code: " + response.code());
                    return;
                }
                List<Posts> posts = response.body();
                for (Posts posts1 : posts) {

                    String content = "";
                    content += posts1.getName() + "\n";
//                    content += "MESSAGE: " + posts1.getMessage() + "\n";
//                    content += "LIVE: " + posts1.isLive() + "\n";
//                    content+= "TIME: " + posts1.getTime( ) + "\n";
                   // content +="" + posts1.getTime( ) + " Learning hours, " +  posts1.getCountry() + "\n\n";


                    // content += "ID:" + posts1.getId() + "\n";
                   *//* content += "User ID:" + posts1.getUserId() + "\n";
                    content += "Title:" + posts1.getTitle() + "\n";
                    content += "Text:" + posts1.getText() + "\n\n";
*//*
                    textViewResult.append(content);
                }*/


            }

            @Override
            public void onFailure(Call<List<Get>> call, Throwable t) {
                //textViewResult.setText(t.getMessage());
            }
        });







    }
}