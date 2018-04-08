package com.kmema.android.geniusproject.view;

import android.app.FragmentManager;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.kmema.android.geniusproject.ContractViewPresenter;
import com.kmema.android.geniusproject.R;
import com.kmema.android.geniusproject.adapter.UsersRecyclerAdapter;
import com.kmema.android.geniusproject.model.UniversalData;
import com.kmema.android.geniusproject.model.UpdatedUserData;
import com.kmema.android.geniusproject.model.UserData;
import com.kmema.android.geniusproject.presenter.PresenterGenius;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ContractViewPresenter.ViewTask, AddUserDialogFragment.FragmentClickListner {


    private ContractViewPresenter.PresenterTask mContractViewPresenter;
    private RecyclerView mRecyclerView;
    private List<UniversalData> mUniversalDataList;
    private UsersRecyclerAdapter mUsersRecyclerAdapter;
    private final String TAG_MAIN_ACTIVITY = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUniversalDataList = new ArrayList<>();
        mContractViewPresenter = new PresenterGenius(this);
        mRecyclerView = findViewById(R.id.rvUserList);
        FloatingActionButton fabAddbtn = findViewById(R.id.fabAddBtn);
        fabAddbtn.setOnClickListener(this);

        if (savedInstanceState != null) {
            mUniversalDataList.addAll(Objects.requireNonNull(savedInstanceState.<UniversalData>getParcelableArrayList("ArrayList")));
            initView();
        } else {
            mContractViewPresenter.getData();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("ArrayList", (ArrayList<? extends Parcelable>) mUniversalDataList);
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabAddBtn:
                displayFragment();
                break;
        }
    }

    private void displayFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        AddUserDialogFragment addUserDialogFragment = AddUserDialogFragment.getInstance();
        addUserDialogFragment.show(fragmentManager, "AddUser");
        Log.i(TAG_MAIN_ACTIVITY, "displayFragment() Called");
    }

    @Override
    public void displayData(List<UniversalData> universalData) {
        mUniversalDataList.addAll(universalData);
        initView();
    }

    private void initView() {
        mUsersRecyclerAdapter = new UsersRecyclerAdapter(mUniversalDataList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mUsersRecyclerAdapter);
        Log.i(TAG_MAIN_ACTIVITY, "InitView() Called");
    }

    @Override
    public void displayError(String errorMessage) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), errorMessage, Snackbar.LENGTH_LONG);
        snackbar.show();
        Log.i(TAG_MAIN_ACTIVITY, "displayError() Called");
    }

    @Override
    public void newUserData(UpdatedUserData updatedUserData) {
        mUniversalDataList.add(updatedUserData);
        mUsersRecyclerAdapter.notifyItemChanged(mUniversalDataList.size());
        Log.i(TAG_MAIN_ACTIVITY, "Accepted");
        Log.i(TAG_MAIN_ACTIVITY, "newUserData() Called");
    }

    @Override
    public boolean userInput(String FirstName, String Job) {
        return mContractViewPresenter.postData(FirstName, Job);
    }
}
