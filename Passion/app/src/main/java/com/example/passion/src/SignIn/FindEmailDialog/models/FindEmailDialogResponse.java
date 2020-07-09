package com.example.passion.src.SignIn.FindEmailDialog.models;

import com.google.gson.annotations.SerializedName;

public class FindEmailDialogResponse {
    @SerializedName("userInfo")
    private UserInfo userInfo;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}