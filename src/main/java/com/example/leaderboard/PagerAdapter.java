package com.example.leaderboard;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class PagerAdapter extends FragmentPagerAdapter {
    int noOfTabs;
   // private static int NUM_ITEMS = 2;

    public PagerAdapter(FragmentManager fragmentManager, int NumberOfTabs)
    {
        super(fragmentManager);
        this.noOfTabs=NumberOfTabs;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                LearningLeaders learningLeaders = new LearningLeaders();

                return learningLeaders.newInstance(0, "0");
            case 1:
                SkillIqLeaders skillIqLeaders = new SkillIqLeaders();
                return skillIqLeaders.newInstance("mpara1"," mpara2");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return noOfTabs;
       // return NUM_ITEMS;
    }

   /* @Override
    public CharSequence getPageTitle(int position ) {

        String textView;
        String textView1;
        textView = "Learning Leaders";
        textView1 ="Skill IQ Leaders";

        if(position == 0){
            return  textView;
        }

        else if(position == 1 ){
            return textView1;
        }
            return "";
    }*/

}
