package com.example.passion.src.SignIn.FindPW.interfaces;

public interface FindPWActivityView {

    void validateFailure(String message);

    void signInSuccess(boolean isSucess, String message);
}
