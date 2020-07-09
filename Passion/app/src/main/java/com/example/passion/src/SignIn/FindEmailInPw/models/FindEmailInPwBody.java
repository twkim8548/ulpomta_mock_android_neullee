package com.example.passion.src.SignIn.FindEmailInPw.models;

import com.google.gson.annotations.SerializedName;

public class FindEmailInPwBody {

    //이메일
    @SerializedName("email")
    private String email;

    public String getEmail() {
        return email;
    }
}