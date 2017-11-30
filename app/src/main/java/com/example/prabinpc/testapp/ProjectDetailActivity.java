package com.example.prabinpc.testapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class ProjectDetailActivity extends AppCompatActivity{
    TextView mTvProjectDescription;
    Repo repo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
        mTvProjectDescription = findViewById(R.id.project_details_tv_description);
        repo =(Repo) getIntent().getExtras().getSerializable("repo");
        mTvProjectDescription.setText(repo.description);
        Toast.makeText(this,"We are in Project Details Page",Toast.LENGTH_LONG);

    }
}
