package com.example.passion.src.SignIn.SingInStart.interfaces;

import com.example.passion.src.SignIn.SingInStart.models.SignInStartBody;
import com.example.passion.src.SignIn.SingInStart.models.SignInStartResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignInStartRetrofitInterface {
    @POST("/signin")
    Call<SignInStartResponse> signInStart(@Body SignInStartBody params);
}
