package com.example.prabinpc.testapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ProjectsAcitivity extends AppCompatActivity{
    //Set TAG
    public static final String TAG = ProjectsAcitivity.class.getSimpleName();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_projects);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        GithubServices service = retrofit.create(GithubServices.class);
        Call<List<Repo>> repos = service.listRepos("Prabin01180");
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> projects = new ArrayList<>();
                 projects.addAll(response.body());
                for (Repo repo : projects) {
                    Log.d(TAG, repo.name);
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.d(TAG, t.getLocalizedMessage());
            }
        });


    }
}
