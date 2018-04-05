package com.kmema.android.geniusproject;

import com.kmema.android.geniusproject.model.UpdatedUserData;
import com.kmema.android.geniusproject.model.UserData;

import java.util.List;

public interface ContractViewPresenter {

    interface PresenterTask{
        void getData();
        boolean postData(String FirstName, String Job);

    }

    interface ViewTask{
        void displayData(List<UserData> userData);
        void displayError(String errorMessage);
        void newUserData(UpdatedUserData updatedUserData);
    }
}
