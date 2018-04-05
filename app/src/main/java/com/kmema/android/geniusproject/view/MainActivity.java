package com.kmema.android.geniusproject.view;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kmema.android.geniusproject.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    RecyclerView mRecyclerView;
    FloatingActionButton fabAddbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rvUserList);
        fabAddbtn = findViewById(R.id.fabAddBtn);
        fabAddbtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

    }
}
