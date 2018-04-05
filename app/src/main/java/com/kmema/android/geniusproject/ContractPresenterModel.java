package com.kmema.android.geniusproject;

import com.kmema.android.geniusproject.model.UpdatedUserData;
import com.kmema.android.geniusproject.model.Users;

public interface ContractPresenterModel {
    interface PresenterTask{
        public void processUsers(Users users);
        public void updatedUser(UpdatedUserData updatedUserData);
        public void processError();
    }

    interface ModelTask{
        public void getUserData();
        public void postUserData(String FirstName, String Job);
    }
}
