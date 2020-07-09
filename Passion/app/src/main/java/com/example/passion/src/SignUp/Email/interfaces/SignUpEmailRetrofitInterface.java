package com.example.passion.src.SignUp.Email.interfaces;

import com.example.passion.src.SignUp.Email.models.SignupEmailResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignUpEmailRetrofitInterface {

    @POST("/signup")
    Call<SignupEmailResponse> signUpEmail (@Body HashMap<String, Object> hashMap);
}
