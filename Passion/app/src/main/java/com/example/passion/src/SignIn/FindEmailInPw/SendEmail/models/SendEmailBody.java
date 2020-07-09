package com.example.passion.src.SignIn.FindEmailInPw.SendEmail.models;

import com.google.gson.annotations.SerializedName;

public class SendEmailBody {

    //이메일
    @SerializedName("email")
    private String email;

    public SendEmailBody(String email) {
        this.email = email;
    }
}