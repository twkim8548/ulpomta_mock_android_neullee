package com.example.passion.src.AppStartActivity.models;

import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("id")
    private int id;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("iat")
    private int iat;

    @SerializedName("exp")
    private int exp;

    @SerializedName("sub")
    private String sub;
}
