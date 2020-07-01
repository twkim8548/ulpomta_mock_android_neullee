package com.example.passion.src.pallosignin.models;

import com.google.gson.annotations.SerializedName;

//post로 body에 있는 내용을 넣어두는 클래스
public class SignInBody {

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    //생성자
    public SignInBody(String email, String password) {
        this.email = email;
        this.password = password;
    }
}