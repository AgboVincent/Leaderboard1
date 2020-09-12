package com.example.leaderboard;

import com.google.gson.annotations.SerializedName;

public class Get {

    @SerializedName("hours")
    private Integer time;
    @SerializedName("score")
    private Integer score;
    @SerializedName("live")
    private boolean live;
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private String country;


    public Integer getTime() {
        return time;
    }
    public Integer getScore() {
        return score;
    }

    public boolean isLive() {
        return live;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }



}
