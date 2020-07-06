package com.example.passion.src.AppStartActivity.interfaces;

import com.example.passion.src.AppStartActivity.models.InfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SplashRetrofitInterface {

    @GET("/check")
    Call<InfoResponse> checkJwt();


}
