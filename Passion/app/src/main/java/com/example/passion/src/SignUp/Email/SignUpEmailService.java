package com.example.passion.src.SignUp.Email;

import com.example.passion.src.SignUp.Email.interfaces.SignUpEmailActivityView;
import com.example.passion.src.SignUp.Email.interfaces.SignUpEmailRetrofitInterface;
import com.example.passion.src.SignUp.Email.models.SignupEmailResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class SignUpEmailService {

    private final SignUpEmailActivityView mSignUpEmailActivityView;

    public SignUpEmailService(final SignUpEmailActivityView signUpEmailActivityView) {
        this.mSignUpEmailActivityView = signUpEmailActivityView;
    }

    //Post 로그인
    public void postSignUpEmail(String email, String password) {
        final SignUpEmailRetrofitInterface signUpEmailRetrofitInterface = getRetrofit().create(SignUpEmailRetrofitInterface.class);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("email", email);
        hashMap.put("password", password);

        signUpEmailRetrofitInterface.signUpEmail(hashMap).enqueue(new Callback<SignupEmailResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<SignupEmailResponse> call, Response<SignupEmailResponse> response) {
                final SignupEmailResponse signupEmailResponse = response.body();
                if (signupEmailResponse == null) {//<설명> 응답이 없을때
                    mSignUpEmailActivityView.signUpEmailFailure(null);
                    return;
                } else if (signupEmailResponse.getCode() == 200) {//<설명> 응답코드(200) : 로그인 성공
                    mSignUpEmailActivityView.signUpEmailSuccess(signupEmailResponse.getMessage());
                } else {//<설명>응답코드(...) :로그인 실패
                    mSignUpEmailActivityView.signUpEmailFailure(signupEmailResponse.getMessage());
                }
            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<SignupEmailResponse> call, Throwable t) {
                mSignUpEmailActivityView.signUpEmailFailure(null);
            }
        });
    }

}
