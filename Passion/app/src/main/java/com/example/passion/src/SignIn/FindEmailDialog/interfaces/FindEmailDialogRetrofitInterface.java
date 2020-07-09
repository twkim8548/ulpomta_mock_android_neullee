package com.example.passion.src.SignIn.FindEmailDialog.interfaces;

import com.example.passion.src.SignIn.FindEmailDialog.models.FindEmailDialogResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FindEmailDialogRetrofitInterface {

    //content는 서버에서 만든 key를 기준으로 해야한다
    @GET("/findemail")
    Call<FindEmailDialogResponse> getEmail(
            @Query("nickname") final String nickname
    );
}
