package com.example.passion.src.SignIn.SingInStart.models;

import com.google.gson.annotations.SerializedName;

public class SignInStartResponse {
    @SerializedName("result")
    private Result result;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;

    public Result getResult() {
        return result;
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