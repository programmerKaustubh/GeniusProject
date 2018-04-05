package com.kmema.android.geniusproject.model;

import android.util.Log;

import com.kmema.android.geniusproject.ContractPresenterModel;
import com.kmema.android.geniusproject.api.ApiCallInterface;
import com.kmema.android.geniusproject.api.ApiClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelGenius implements ContractPresenterModel.ModelTask{

    private final String TAG_MODELGENIUS = "ModelGenius";
    private ContractPresenterModel.PresenterTask mPresenterTask;
    private ApiCallInterface mApiCallInterface;
    private Call<Users> usersGetCall;


    public ModelGenius(ContractPresenterModel.PresenterTask presenterTask){
        this.mPresenterTask = presenterTask;
        mApiCallInterface = ApiClient.getClient().create(
                ApiCallInterface.class
        );
    }

    @Override
    public void getUserData() {
        usersGetCall = mApiCallInterface.USER_DATA_CALL();
        usersGetCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                Log.i(TAG_MODELGENIUS, "onResponse() called");

                if(response.isSuccessful()){
                    Users users = response.body();
                    mPresenterTask.processUsers(users);
                }else{
                    mPresenterTask.processError(response);
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Log.i(TAG_MODELGENIUS, "onFailure() called");
                if(t instanceof IOException){
                    mPresenterTask.failedConnection("Network Failure, Retry Later");
                }else{

                }
            }
        });
    }

    @Override
    public void postUserData(String FirstName, String Job) {

    }
}
