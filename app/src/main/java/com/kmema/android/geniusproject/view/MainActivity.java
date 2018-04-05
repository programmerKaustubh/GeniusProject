package com.kmema.android.geniusproject.view;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kmema.android.geniusproject.ContractPresenterModel;
import com.kmema.android.geniusproject.ContractViewPresenter;
import com.kmema.android.geniusproject.R;
import com.kmema.android.geniusproject.adapter.UsersAdapter;
import com.kmema.android.geniusproject.model.UpdatedUserData;
import com.kmema.android.geniusproject.model.UserData;
import com.kmema.android.geniusproject.presenter.PresenterGenius;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ContractViewPresenter.ViewTask{


    ContractViewPresenter.PresenterTask mContractViewPresenter;
    RecyclerView mRecyclerView;
    FloatingActionButton fabAddbtn;
    List<Object> oldObjects, updatedList;
    UsersAdapter mUsersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContractViewPresenter = new PresenterGenius(this);
        mContractViewPresenter.getData();
        mRecyclerView = findViewById(R.id.rvUserList);
        fabAddbtn = findViewById(R.id.fabAddBtn);
        fabAddbtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void displayData(List<UserData> userData) {
        oldObjects = Arrays.asList(userData.toArray());
        updatedList = new ArrayList<>(oldObjects);
        mUsersAdapter = new UsersAdapter(updatedList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mUsersAdapter);

    }

    @Override
    public void displayError(String errorMessage) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),errorMessage,Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void newUserData(UpdatedUserData updatedUserData) {

    }
}
