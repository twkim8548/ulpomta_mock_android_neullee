package com.example.passion.src.SignIn.FindEmailDialog.models;

import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("email")
    private String email;

    @SerializedName("createdAt")
    private String createdAt;

    public String getEmail() {
        return email;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
