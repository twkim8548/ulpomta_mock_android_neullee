package com.example.passion.src.SignIn.SingInStart.models;

import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("idx")
    private int idx;

    @SerializedName("email")
    private String email;

    @SerializedName("pswd")
    private String pswd;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("status")
    private String status;

    public int getIdx() {
        return idx;
    }

    public String getEmail() {
        return email;
    }

    public String getPswd() {
        return pswd;
    }

    public String getNickname() {
        return nickname;
    }

    public String getStatus() {
        return status;
    }
}
