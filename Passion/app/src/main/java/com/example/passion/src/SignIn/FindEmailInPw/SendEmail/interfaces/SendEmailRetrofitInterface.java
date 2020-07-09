package com.example.passion.src.SignIn.FindEmailInPw.SendEmail.interfaces;

import com.example.passion.src.SignIn.FindEmailInPw.SendEmail.models.SendEmailBody;
import com.example.passion.src.SignIn.FindEmailInPw.SendEmail.models.SendEmailResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SendEmailRetrofitInterface {
    @POST("/findpswd")//바꿔야함!! -> 원 아직 만들고 있음
    Call<SendEmailResponse> getFindEmailInPw(@Body SendEmailBody params);
}
