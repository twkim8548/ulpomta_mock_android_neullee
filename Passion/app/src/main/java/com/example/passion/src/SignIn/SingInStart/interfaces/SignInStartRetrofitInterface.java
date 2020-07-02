package com.example.passion.src.SignIn.SingInStart.interfaces;

import com.example.passion.src.SignIn.SingInStart.models.SignInBody;
import com.example.passion.src.SignIn.SingInStart.models.SignInResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignInStartRetrofitInterface {
    @POST("/signin")
    Call<SignInResponse> signInTest(@Body SignInBody params);
}
