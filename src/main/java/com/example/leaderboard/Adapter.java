
package com.example.leaderboard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    List<Get> posts;

    public Adapter( Context c, List<Get> p){

        context = c;
        posts = p;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new  ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_learning_leaders,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(posts.get(position).getName());
        holder.time.setText(posts.get(position).getTime() + " Learning hours, " + posts.get(position).getCountry());
        holder.time.setText(posts.get(position).getScore() + " Skill IQ score, " + posts.get(position).getCountry());
     /*   String imageUrl = posts.get(position).getUrl();




        Glide.with(context)
                .load(imageUrl)
                .into(holder.imageView);
*/

    }

    @Override
    public int getItemCount() {
        return posts.size() ;

    }

    static class ViewHolder extends RecyclerView.ViewHolder

    {
        ImageView imageView;
        TextView name, time;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_name);
            time = itemView.findViewById(R.id.text_time);
            imageView = itemView.findViewById(R.id.image);






        }
    }
}
