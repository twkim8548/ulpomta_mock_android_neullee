package com.example.passion.src.SignIn.FindPW;

import com.example.passion.src.SignIn.FindPW.interfaces.FindPWActivityView;
import com.example.passion.src.SignIn.FindPW.interfaces.FindPWRetrofitInterface;
import com.example.passion.src.SignIn.FindPW.models.FindPWBody;
import com.example.passion.src.SignIn.FindPW.models.FindPWResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class FindPWService {
    private final FindPWActivityView mFindPWActivityView;

    public FindPWService(final FindPWActivityView findPWActivityView) {
        this.mFindPWActivityView = findPWActivityView;
    }

    //Post 로그인
    public void postSingIn(String email, String password) {
        final FindPWRetrofitInterface findPWRetrofitInterface = getRetrofit().create(FindPWRetrofitInterface.class);
        findPWRetrofitInterface.signInTest(new FindPWBody(email, password)).enqueue(new Callback<FindPWResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<FindPWResponse> call, Response<FindPWResponse> response) {
                final FindPWResponse findPWResponse = response.body();
                if (findPWResponse == null) {
                    mFindPWActivityView.validateFailure(null);
                    return;
                }

                mFindPWActivityView.signInSuccess(findPWResponse.getIsSuccess(), findPWResponse.getMessage());//반환값

            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<FindPWResponse> call, Throwable t) {
                mFindPWActivityView.validateFailure(null);
            }
        });
    }

}
