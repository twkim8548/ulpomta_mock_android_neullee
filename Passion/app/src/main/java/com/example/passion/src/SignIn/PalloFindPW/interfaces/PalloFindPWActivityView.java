package com.example.passion.src.SignIn.PalloFindPW.interfaces;

public interface PalloFindPWActivityView {

    void validateFailure(String message);

    void signInSuccess(boolean isSucess, String message);
}
