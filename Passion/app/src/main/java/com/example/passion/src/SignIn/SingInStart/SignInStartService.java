package com.example.passion.src.SignIn.SingInStart;

import com.example.passion.src.SignIn.SingInStart.interfaces.SignInStartActivityView;
import com.example.passion.src.SignIn.SingInStart.interfaces.SignInStartRetrofitInterface;
import com.example.passion.src.SignIn.SingInStart.models.SignInBody;
import com.example.passion.src.SignIn.SingInStart.models.SignInResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class SignInStartService {
    private final SignInStartActivityView mSignInStartActivityView;

    public SignInStartService(final SignInStartActivityView signInStartActivityView) {
        this.mSignInStartActivityView = signInStartActivityView;
    }

    //Post 로그인
    public void postSingIn(String email, String password) {
        final SignInStartRetrofitInterface signInStartRetrofitInterface = getRetrofit().create(SignInStartRetrofitInterface.class);
        signInStartRetrofitInterface.signInTest(new SignInBody(email, password)).enqueue(new Callback<SignInResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                final SignInResponse signInResponse = response.body();
                if (signInResponse == null) {
                    mSignInStartActivityView.validateFailure(null);
                    return;
                }

                mSignInStartActivityView.signInSuccess(signInResponse.getIsSuccess(),signInResponse.getMessage());//반환값

            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<SignInResponse> call, Throwable t) {
                mSignInStartActivityView.validateFailure(null);
            }
        });
    }

}
