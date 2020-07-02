package com.example.passion.src.SignIn.FindPW.interfaces;

import com.example.passion.src.SignIn.FindPW.models.FindPWBody;
import com.example.passion.src.SignIn.FindPW.models.FindPWResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FindPWRetrofitInterface {
    @POST("/signin")
    Call<FindPWResponse> signInTest(@Body FindPWBody params);
}
