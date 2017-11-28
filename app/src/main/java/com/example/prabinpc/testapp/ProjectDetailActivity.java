package com.example.prabinpc.testapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ProjectDetailActivity extends AppCompatActivity{
    TextView mTvProjectDiscription;
    Repo repo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
        mTvProjectDiscription = findViewById(R.id.project_details_tv_description);
        repo =(Repo) getIntent().getExtras().getSerializable("repo");
        mTvProjectDiscription.setText(repo.html_url);
    }
}
