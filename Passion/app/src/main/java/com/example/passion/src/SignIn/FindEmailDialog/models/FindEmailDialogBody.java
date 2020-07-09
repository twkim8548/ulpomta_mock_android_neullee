package com.example.passion.src.SignIn.FindEmailDialog.models;

import com.google.gson.annotations.SerializedName;

public class FindEmailDialogBody {
    @SerializedName("nickname")
    private String nickname;

    public String getNickname() {
        return nickname;
    }
}
