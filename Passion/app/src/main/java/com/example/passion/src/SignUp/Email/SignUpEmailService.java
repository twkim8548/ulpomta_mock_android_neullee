package com.example.passion.src.SignUp.Email;

import com.example.passion.src.SignUp.Email.interfaces.SignUpEmailActivityView;

public class SignUpEmailService {
    private final SignUpEmailActivityView mSignUpEmailActivityView;

    public SignUpEmailService(final SignUpEmailActivityView signUpEmailActivityView) {
        this.mSignUpEmailActivityView = signUpEmailActivityView;
    }

    //[확인] API가 나오면 코드 수정
//    public void postSignUpEmail() {
//        final FindEmailInPwRetrofitInterface palloSignInRetrofitInterface = getRetrofit().create(FindEmailInPwRetrofitInterface.class);
//        palloSignInRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
//            @Override
//            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
//                final DefaultResponse defaultResponse = response.body();
//                if (defaultResponse == null) {
//                    mSignUpEmailActivityView.validateFailure(null);
//                    return;
//                }
//
//                mSignUpEmailActivityView.validateSuccess(defaultResponse.getMessage());
//            }
//
//            @Override
//            public void onFailure(Call<DefaultResponse> call, Throwable t) {
//                mSignUpEmailActivityView.validateFailure(null);
//            }
//        });
//    }
}
