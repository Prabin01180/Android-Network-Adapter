package com.example.prabinpc.testapp;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface GithubServices  {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}