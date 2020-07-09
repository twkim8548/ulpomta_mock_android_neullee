package com.example.passion.src.SignIn.FindEmailDialog.interfaces;

import com.example.passion.src.SignIn.FindEmailDialog.models.UserInfo;

public interface FindEmailDialogActivityView {

    void signInStartDialogSuccess(UserInfo userInfo);

    void signInStartDialogFailure(UserInfo userInfo);
}
