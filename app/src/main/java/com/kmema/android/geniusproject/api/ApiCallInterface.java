package com.kmema.android.geniusproject.api;

import com.kmema.android.geniusproject.model.Users;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCallInterface {

    @GET("/api/users")
    Call<Users> USER_DATA_CALL();

}
