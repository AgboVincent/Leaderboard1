package com.example.leaderboard;

import com.google.gson.annotations.SerializedName;

public class Post {

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






    @SerializedName("firstName")
    private  String firstname;
    @SerializedName("lastName")
    private  String lastname;
    @SerializedName("emailAddress")

    private  String emailaddress;

    @SerializedName("githubLink")
    private  String projectlink;


    public Post(){


    }



    public Post(String firstname, String lastname, String emailaddress, String projectlink) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.projectlink = projectlink;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getProjectlink() {
        return projectlink;
    }

    public void setProjectlink(String projectlink) {
        this.projectlink = projectlink;
    }



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
