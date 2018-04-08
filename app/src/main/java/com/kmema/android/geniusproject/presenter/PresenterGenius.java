package com.kmema.android.geniusproject.presenter;

import android.util.Log;

import com.kmema.android.geniusproject.ContractPresenterModel;
import com.kmema.android.geniusproject.ContractViewPresenter;
import com.kmema.android.geniusproject.api.ApiError;
import com.kmema.android.geniusproject.model.UniversalData;
import com.kmema.android.geniusproject.utils.ErrorUtils;
import com.kmema.android.geniusproject.model.ModelGenius;
import com.kmema.android.geniusproject.model.UpdatedUserData;
import com.kmema.android.geniusproject.model.UserData;
import com.kmema.android.geniusproject.model.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import retrofit2.Response;

public class PresenterGenius implements ContractViewPresenter.PresenterTask, ContractPresenterModel.PresenterTask {

    private ContractPresenterModel.ModelTask mModelTask = new ModelGenius(this);
    private final String TAG_PRESENTER = "PresenterGenius";
    private ContractViewPresenter.ViewTask viewTask;
    private List<UniversalData> universalDataList;

    public PresenterGenius(ContractViewPresenter.ViewTask viewTask) {
        this.viewTask = viewTask;
        universalDataList = new ArrayList<>();
    }

    @Override
    public void getData() {
        Log.i(TAG_PRESENTER, "getData() Called");
        mModelTask.getUserData();
    }

    @Override
    public boolean postData(String FirstName, String Job) {
        if (FirstName != null && !FirstName.isEmpty() && Job != null && !Job.isEmpty()) {
            mModelTask.postUserData(FirstName, Job);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void processUsers(Users users) {
        Log.i(TAG_PRESENTER, "processUsers() Called");
        universalDataList.addAll(Arrays.asList(users.getData()));
        viewTask.displayData(universalDataList);
    }

    @Override
    public void updatedUser(UpdatedUserData updatedUserData) {
        viewTask.newUserData(updatedUserData);
    }

    @Override
    public void processError(Response<?> response) {
        ApiError apiError = ErrorUtils.parseError(response);
        viewTask.displayError(apiError.getError());
    }

    @Override
    public void failedConnection(String errorMssage) {
        viewTask.displayError(errorMssage);
    }
}
