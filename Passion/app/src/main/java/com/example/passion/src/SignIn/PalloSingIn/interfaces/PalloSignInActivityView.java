package com.example.passion.src.SignIn.PalloSingIn.interfaces;

public interface PalloSignInActivityView {

    void validateFailure(String message);

    void signInSuccess(boolean isSucess, String message);
}
