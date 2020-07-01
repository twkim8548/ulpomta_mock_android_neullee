package com.example.passion.src.pallosignin.models;

import com.google.gson.annotations.SerializedName;

public class SignInResponse {

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

    @SerializedName("userInfo")
    private UserInfo userInfo;

    @SerializedName("jwt")
    private String jwt;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public String getJwt() {
        return jwt;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }
}