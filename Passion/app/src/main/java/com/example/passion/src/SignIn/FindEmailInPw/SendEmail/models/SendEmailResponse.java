package com.example.passion.src.SignIn.FindEmailInPw.SendEmail.models;

import com.google.gson.annotations.SerializedName;

public class SendEmailResponse {

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

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