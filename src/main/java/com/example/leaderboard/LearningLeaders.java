package com.example.leaderboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static android.graphics.Color.GREEN;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearningLeaders#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearningLeaders extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   // private static final String ARG_PARAM1 = "2";
    //private static final String ARG_PARAM2 = "Learning Leaders";

    // TODO: Rename and change types of parameters
    private String title;
    private int page;

    public LearningLeaders() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static LearningLeaders newInstance(int page, String title) {
        LearningLeaders fragment = new LearningLeaders();
        Bundle args = new Bundle();
        args.putInt("page", page);
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

           page = getArguments().getInt("page",0);
            title = getArguments().getString("title");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        // Inflate the layout for this fragment
        return view;
    }
}