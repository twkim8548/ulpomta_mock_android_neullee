package com.example.passion.src.SignIn.SingInStart.Dialog.interfaces;

import com.example.passion.src.SignIn.SingInStart.Dialog.models.SignInStartDialogResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SignInStartDialogRetrofitInterface {

    @GET("/findemail")
    Call<SignInStartDialogResponse> getEmail(
            @Query("nickname") final String nickname
    );

}
