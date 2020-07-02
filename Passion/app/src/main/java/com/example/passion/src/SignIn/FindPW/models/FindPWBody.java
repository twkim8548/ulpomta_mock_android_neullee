package com.example.passion.src.SignIn.FindPW.models;

import com.google.gson.annotations.SerializedName;

//post로 body에 있는 내용을 넣어두는 클래스
public class FindPWBody {

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    //생성자
    public FindPWBody(String email, String password) {
        this.email = email;
        this.password = password;
    }
}