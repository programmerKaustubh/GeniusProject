package com.kmema.android.geniusproject.api;

import com.kmema.android.geniusproject.model.UpdateUser;
import com.kmema.android.geniusproject.model.UpdatedUserData;
import com.kmema.android.geniusproject.model.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiCallInterface {

    @GET("/api/users")
    Call<Users> USER_DATA_CALL();

    @POST("/api/users")
    Call<UpdatedUserData> ADD_USER_CALL(@Body UpdateUser updateUser);
}
