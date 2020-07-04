package com.example.passion.src.SignIn.SingInStart.Dialog.models;

import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("email")
    private String email;

    @SerializedName("createdAt")
    private String pswd;

    public String getEmail() {
        return email;
    }

    public String getPswd() {
        return pswd;
    }
}
