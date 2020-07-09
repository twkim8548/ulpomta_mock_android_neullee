package com.example.passion.src.SignIn.FindEmailInPw.interfaces;

import com.example.passion.src.SignIn.FindEmailInPw.models.FindEmailInPwResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FindEmailInPwRetrofitInterface {
    @POST("/checke1")//바꿔야함!! -> 원 아직 만들고 있음
    Call<FindEmailInPwResponse> getFindEmailInPw(@Body String email);
}
