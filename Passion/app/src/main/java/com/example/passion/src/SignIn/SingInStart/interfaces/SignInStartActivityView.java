package com.example.passion.src.SignIn.SingInStart.interfaces;

public interface SignInStartActivityView {

    void validateFailure(String message);

    void signInSuccess(boolean isSucess, String message);
}
