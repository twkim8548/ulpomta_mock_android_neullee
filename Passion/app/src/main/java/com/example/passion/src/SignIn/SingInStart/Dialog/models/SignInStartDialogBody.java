package com.example.passion.src.SignIn.SingInStart.Dialog.models;

import com.google.gson.annotations.SerializedName;

public class SignInStartDialogBody {
    @SerializedName("nickname")
    private String nickname;

    public String getNickname() {
        return nickname;
    }
}
