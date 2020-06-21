package com.example.facebookv2.data;

import com.example.facebookv2.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static final String BACE_URL ="https://jsonplaceholder.typicode.com/";
    private PostInterfaca postInterfaca;
    private  static PostsClient INSTANCE;

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BACE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterfaca = retrofit.create(PostInterfaca.class);
    }

    public static PostsClient getINSTANCE() {
        if(null==INSTANCE){
            INSTANCE = new PostsClient();
        }
        return INSTANCE;
    }

    public Call<List<PostModel>> getPosts(){
        return postInterfaca.getpost();
    }
}
