package com.example.passion.src.SignUp.Email.interfaces;

import com.example.passion.src.SignUp.Email.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignUpEmailRetrofitInterface {

    @POST("/signup")
    Call<DefaultResponse> signUpEmail (@Body RequestBody params);
}
