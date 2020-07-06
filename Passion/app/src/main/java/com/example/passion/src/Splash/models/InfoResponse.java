package com.example.passion.src.Splash.models;

import com.google.gson.annotations.SerializedName;

public class InfoResponse {

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("info")
    private Info info;

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Info getInfo() {
        return info;
    }
}
