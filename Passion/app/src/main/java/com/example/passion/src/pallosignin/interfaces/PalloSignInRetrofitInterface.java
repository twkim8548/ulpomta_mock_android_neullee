package com.example.passion.src.pallosignin.interfaces;

import com.example.passion.src.pallosignin.models.SignInBody;
import com.example.passion.src.pallosignin.models.SignInResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PalloSignInRetrofitInterface {
    @POST("/signin")
    Call<SignInResponse> signInTest(@Body SignInBody params);
}
