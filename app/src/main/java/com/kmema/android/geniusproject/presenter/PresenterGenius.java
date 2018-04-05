package com.kmema.android.geniusproject.presenter;

import android.util.Log;

import com.kmema.android.geniusproject.ContractPresenterModel;
import com.kmema.android.geniusproject.ContractViewPresenter;
import com.kmema.android.geniusproject.model.ModelGenius;
import com.kmema.android.geniusproject.model.UpdatedUserData;
import com.kmema.android.geniusproject.model.UserData;
import com.kmema.android.geniusproject.model.Users;

import java.util.Arrays;
import java.util.List;

public class PresenterGenius implements ContractViewPresenter.PresenterTask, ContractPresenterModel.PresenterTask {

    private ContractPresenterModel.ModelTask mModelTask = new ModelGenius(this);
    private final String TAG_PRESENTER = "PresenterGenius";
    private ContractViewPresenter.ViewTask viewTask;




    public PresenterGenius(ContractViewPresenter.ViewTask viewTask) {
        this.viewTask = viewTask;
    }



    @Override
    public void getData() {
        Log.i(TAG_PRESENTER, "getData() Called");
        mModelTask.getUserData();
    }

    @Override
    public boolean postData(String FirstName, String Job) {
        return false;
    }

    @Override
    public void processUsers(Users users) {
        Log.i(TAG_PRESENTER, "processUsers() Called");
        List<UserData> mUserData = transformData(users);
        viewTask.displayData(mUserData);
    }

    private List<UserData> transformData(Users users) {
        List<UserData> userData = Arrays.asList(users.getData());
        Log.i(TAG_PRESENTER, "Transform() Called" + userData.get(1));
        return userData;
    }

    @Override
    public void updatedUser(UpdatedUserData updatedUserData) {

    }

    @Override
    public void processError() {

    }
}