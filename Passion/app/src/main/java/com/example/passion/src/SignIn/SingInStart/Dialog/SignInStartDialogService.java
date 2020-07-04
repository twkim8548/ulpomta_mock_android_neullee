package com.example.passion.src.SignIn.SingInStart.Dialog;

import com.example.passion.src.SignIn.SingInStart.Dialog.interfaces.SignInStartDialogActivityView;
import com.example.passion.src.SignIn.SingInStart.Dialog.interfaces.SignInStartDialogRetrofitInterface;
import com.example.passion.src.SignIn.SingInStart.Dialog.models.SignInStartDialogBody;
import com.example.passion.src.SignIn.SingInStart.Dialog.models.SignInStartDialogResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class SignInStartDialogService {
    private final SignInStartDialogActivityView mSignInStartDialogActivityView;

    public SignInStartDialogService(final SignInStartDialogActivityView signInStartDialogActivityView) {
        this.mSignInStartDialogActivityView = signInStartDialogActivityView;
    }

    //Post 로그인
    public void getSingInStartDialog(String nickname) {
        final SignInStartDialogRetrofitInterface signInStartDialogRetrofitInterface = getRetrofit().create(SignInStartDialogRetrofitInterface.class);
        signInStartDialogRetrofitInterface.getEmail(nickname).enqueue(new Callback<SignInStartDialogResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<SignInStartDialogResponse> call, Response<SignInStartDialogResponse> response) {
                final SignInStartDialogResponse signInStartDialogResponse = response.body();
                if (signInStartDialogResponse == null) {//<설명> 응답이 없을때
                    mSignInStartDialogActivityView.signInStartDialogFailure(null);
                    return;
                } else if (signInStartDialogResponse.getCode() == 200) {//<설명> 응답코드(200) : 로그인 성공
                    mSignInStartDialogActivityView.signInStartDialogSuccess(signInStartDialogResponse.getUserInfo());
                } else {//<설명>응답코드(...) :로그인 실패
                    mSignInStartDialogActivityView.signInStartDialogFailure(signInStartDialogResponse.getUserInfo());
                }
            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<SignInStartDialogResponse> call, Throwable t) {
                mSignInStartDialogActivityView.signInStartDialogFailure(null);
            }
        });
    }

}
