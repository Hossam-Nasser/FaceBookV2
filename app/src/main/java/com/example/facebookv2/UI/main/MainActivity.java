package com.example.facebookv2.UI.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facebookv2.R;
import com.example.facebookv2.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel;
    PostsAdpater adpater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);

        postViewModel.getposts();
        RecyclerView recyclerView =findViewById(R.id.recycler);
        adpater =new PostsAdpater();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adpater);

        postViewModel.postMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adpater.setlist((ArrayList<PostModel>) postModels);
            }
        });
    }
}
