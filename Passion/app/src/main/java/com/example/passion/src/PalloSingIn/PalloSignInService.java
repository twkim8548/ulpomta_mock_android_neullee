package com.example.passion.src.PalloSingIn;

import com.example.passion.src.PalloSingIn.interfaces.PalloSignInActivityView;
import com.example.passion.src.PalloSingIn.interfaces.PalloSignInRetrofitInterface;
import com.example.passion.src.PalloSingIn.models.SignInBody;
import com.example.passion.src.PalloSingIn.models.SignInResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class PalloSignInService {
    private final PalloSignInActivityView mPalloSignInActivityView;

    public PalloSignInService(final PalloSignInActivityView palloSignInActivityView) {
        this.mPalloSignInActivityView = palloSignInActivityView;
    }

    //Post 로그인
    public void postSingIn(String email, String password) {
        final PalloSignInRetrofitInterface palloSignInRetrofitInterface = getRetrofit().create(PalloSignInRetrofitInterface.class);
        palloSignInRetrofitInterface.signInTest(new SignInBody(email, password)).enqueue(new Callback<SignInResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                final SignInResponse signInResponse = response.body();
                if (signInResponse == null) {
                    mPalloSignInActivityView.validateFailure(null);
                    return;
                }

                mPalloSignInActivityView.signInSuccess(signInResponse.getIsSuccess(),signInResponse.getMessage());//반환값

            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<SignInResponse> call, Throwable t) {
                mPalloSignInActivityView.validateFailure(null);
            }
        });
    }

}
