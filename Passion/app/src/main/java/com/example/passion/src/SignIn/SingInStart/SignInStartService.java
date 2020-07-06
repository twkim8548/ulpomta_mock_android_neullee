package com.example.passion.src.SignIn.SingInStart;

import com.example.passion.src.SignIn.SingInStart.interfaces.SignInStartActivityView;
import com.example.passion.src.SignIn.SingInStart.interfaces.SignInStartRetrofitInterface;
import com.example.passion.src.SignIn.SingInStart.models.SignInStartResponse;

import java.util.HashMap;

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
    public void postSingInStart(String email, String password) {
        final SignInStartRetrofitInterface signInStartRetrofitInterface = getRetrofit().create(SignInStartRetrofitInterface.class);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("email", email);
        hashMap.put("password", password);

        signInStartRetrofitInterface.signInStart(hashMap).enqueue(new Callback<SignInStartResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<SignInStartResponse> call, Response<SignInStartResponse> response) {
                final SignInStartResponse signInStartResponse = response.body();
                if (signInStartResponse == null) {//<설명> 응답이 없을때
                    mSignInStartActivityView.signInStartFailure(null);
                    return;
                } else if (signInStartResponse.getCode() == 200) {//<설명> 응답코드(200) : 로그인 성공
                    mSignInStartActivityView.signInStartSuccess(signInStartResponse.getResult().getJwt());
                } else {//<설명>응답코드(...) :로그인 실패
                    mSignInStartActivityView.signInStartFailure(signInStartResponse.getMessage());
                }
            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<SignInStartResponse> call, Throwable t) {
                mSignInStartActivityView.signInStartFailure(null);
            }
        });
    }

}
