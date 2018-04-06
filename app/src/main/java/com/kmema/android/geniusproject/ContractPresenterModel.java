package com.kmema.android.geniusproject;

import com.kmema.android.geniusproject.model.UpdatedUserData;
import com.kmema.android.geniusproject.model.Users;

import retrofit2.Response;

public interface ContractPresenterModel {
    interface PresenterTask{
        void processUsers(Users users);
        void updatedUser(UpdatedUserData updatedUserData);
        void processError(Response<?> response);
        void failedConnection(String errorMessage);
    }

    interface ModelTask{
        void getUserData();
        void postUserData(String FirstName, String Job);
    }
}
