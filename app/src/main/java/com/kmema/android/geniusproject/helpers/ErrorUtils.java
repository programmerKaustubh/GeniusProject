package com.kmema.android.geniusproject.helpers;

import com.kmema.android.geniusproject.api.ApiClient;
import com.kmema.android.geniusproject.api.ApiError;
import com.kmema.android.geniusproject.view.MainActivity;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtils {

    public static ApiError parseError(Response<?>  response){
        Converter<ResponseBody, ApiError> converter =
        ApiClient.getClient().responseBodyConverter(ApiError.class,new Annotation[0]);

        ApiError apiError;
        try{
            apiError = converter.convert(response.errorBody());
        } catch (IOException e) {
           return new ApiError();
        }
        return apiError;
    }
}
