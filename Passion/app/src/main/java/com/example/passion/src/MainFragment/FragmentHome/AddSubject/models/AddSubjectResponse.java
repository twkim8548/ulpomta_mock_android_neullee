package com.example.passion.src.MainFragment.FragmentHome.AddSubject.models;

import com.google.gson.annotations.SerializedName;

public class AddSubjectResponse {

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