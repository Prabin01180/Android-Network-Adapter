package com.example.prabinpc.testapp;


import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieActivity extends Activity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        recyclerView=findViewById(R.id.rv_repos);
        getRepository();
    }

    private void getRepository() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubServices services =  retrofit.create(GithubServices.class);
        services.listRepos("Prabin01180").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                for (Repo repo : response.body()){
                    Log.d("repos name",repo.name);
                }
                RepoAdapter repoAdapter = new RepoAdapter(response.body(),MovieActivity.this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MovieActivity.this);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(repoAdapter);

            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }
}
