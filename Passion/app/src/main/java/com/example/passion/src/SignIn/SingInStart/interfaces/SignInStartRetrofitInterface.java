package com.example.passion.src.SignIn.SingInStart.interfaces;

import com.example.passion.src.SignIn.SingInStart.models.SignInStartResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SignInStartRetrofitInterface {
    @POST("/signin")
    Call<SignInStartResponse> signInStart(
            @Header("X-Access-Token") String jwt,
            @Body HashMap<String, Object> hashMap);
}
