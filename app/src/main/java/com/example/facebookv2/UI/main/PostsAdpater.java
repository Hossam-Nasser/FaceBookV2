package com.example.facebookv2.UI.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookv2.R;
import com.example.facebookv2.pojo.PostModel;
//import com.example.myapplicationfarment.R;
//import com.example.myapplicationfarment.pojo.PostModel;


import java.util.ArrayList;

public class PostsAdpater extends RecyclerView.Adapter<PostsAdpater.PostViewHolder> {
    private ArrayList<PostModel> movielist = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
         holder.titleTV.setText(movielist.get(position).getTitle());
         holder.userIDTV.setText(movielist.get(position).getUserId()+"");
         holder.bodyTV.setText(movielist.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return movielist.size();
    }

    public void setlist(ArrayList<PostModel> movielist) {
        this.movielist = movielist;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV,userIDTV,bodyTV;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            userIDTV = itemView.findViewById(R.id.userIDTV);
            bodyTV = itemView.findViewById(R.id.bodyTV);

        }
    }
}
