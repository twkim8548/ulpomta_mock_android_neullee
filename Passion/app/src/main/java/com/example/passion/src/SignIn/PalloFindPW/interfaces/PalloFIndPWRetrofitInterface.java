package com.example.passion.src.SignIn.PalloFindPW.interfaces;

import com.example.passion.src.SignIn.PalloFindPW.models.PalloFIndPWBody;
import com.example.passion.src.SignIn.PalloFindPW.models.PalloFIndPWResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PalloFIndPWRetrofitInterface {
    @POST("/signin")
    Call<PalloFIndPWResponse> signInTest(@Body PalloFIndPWBody params);
}
