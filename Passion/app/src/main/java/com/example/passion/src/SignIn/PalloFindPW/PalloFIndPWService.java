package com.example.passion.src.SignIn.PalloFindPW;

import com.example.passion.src.SignIn.PalloFindPW.interfaces.PalloFindPWActivityView;
import com.example.passion.src.SignIn.PalloFindPW.interfaces.PalloFIndPWRetrofitInterface;
import com.example.passion.src.SignIn.PalloFindPW.models.PalloFIndPWBody;
import com.example.passion.src.SignIn.PalloFindPW.models.PalloFIndPWResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class PalloFIndPWService {
    private final PalloFindPWActivityView mPalloFindPWActivityView;

    public PalloFIndPWService(final PalloFindPWActivityView palloFindPWActivityView) {
        this.mPalloFindPWActivityView = palloFindPWActivityView;
    }

    //Post 로그인
    public void postSingIn(String email, String password) {
        final PalloFIndPWRetrofitInterface palloFIndPWRetrofitInterface = getRetrofit().create(PalloFIndPWRetrofitInterface.class);
        palloFIndPWRetrofitInterface.signInTest(new PalloFIndPWBody(email, password)).enqueue(new Callback<PalloFIndPWResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<PalloFIndPWResponse> call, Response<PalloFIndPWResponse> response) {
                final PalloFIndPWResponse palloFIndPWResponse = response.body();
                if (palloFIndPWResponse == null) {
                    mPalloFindPWActivityView.validateFailure(null);
                    return;
                }

                mPalloFindPWActivityView.signInSuccess(palloFIndPWResponse.getIsSuccess(), palloFIndPWResponse.getMessage());//반환값

            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<PalloFIndPWResponse> call, Throwable t) {
                mPalloFindPWActivityView.validateFailure(null);
            }
        });
    }

}
