package com.example.passion.src.Splash.interfaces;

import com.example.passion.src.Splash.models.InfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface SplashRetrofitInterface {

    @GET("/check")
    Call<InfoResponse> checkJwt(
    );


}
