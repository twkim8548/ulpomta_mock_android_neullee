package com.example.passion.src.SignIn.SingInStart.models;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("jwt")
    private String jwt;

    @SerializedName("userInfo")
    private UserInfo userInfo;

    public String getJwt() {
        return jwt;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}
