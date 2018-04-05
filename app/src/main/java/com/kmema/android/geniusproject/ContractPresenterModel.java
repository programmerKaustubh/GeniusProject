package com.kmema.android.geniusproject;

import com.kmema.android.geniusproject.model.UpdatedUserData;
import com.kmema.android.geniusproject.model.Users;

import retrofit2.Response;

public interface ContractPresenterModel {
    interface PresenterTask{
        public void processUsers(Users users);
        public void updatedUser(UpdatedUserData updatedUserData);
        public void processError(Response<?> response);
        public void failedConnection(String errorMssage);
    }

    interface ModelTask{
        public void getUserData();
        public void postUserData(String FirstName, String Job);
    }
}
