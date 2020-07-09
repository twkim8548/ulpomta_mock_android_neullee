package com.example.passion.src.SignUp.Email.models;

import com.google.gson.annotations.SerializedName;

public class SignupEmailBody {
    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
