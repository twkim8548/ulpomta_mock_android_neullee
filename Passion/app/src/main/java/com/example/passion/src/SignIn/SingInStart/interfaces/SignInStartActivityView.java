package com.example.passion.src.SignIn.SingInStart.interfaces;

public interface SignInStartActivityView {

    void signInStartSuccess(String jwt);

    void signInStartFailure(String message);
}
