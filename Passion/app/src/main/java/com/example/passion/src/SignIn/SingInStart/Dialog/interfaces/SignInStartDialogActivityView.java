package com.example.passion.src.SignIn.SingInStart.Dialog.interfaces;

import com.example.passion.src.SignIn.SingInStart.Dialog.models.UserInfo;

public interface SignInStartDialogActivityView {

    void signInStartDialogSuccess(UserInfo userInfo);

    void signInStartDialogFailure(UserInfo userInfo);
}
