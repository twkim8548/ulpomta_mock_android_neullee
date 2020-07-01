package com.example.passion.src.pallosignin.interfaces;

public interface PalloSignInActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void signInSuccess(boolean isSucess, String message);
}
