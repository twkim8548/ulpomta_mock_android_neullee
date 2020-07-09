package com.example.passion.src.SignIn.FindEmailInPw;

import com.example.passion.src.SignIn.FindEmailInPw.interfaces.FindEmailInPwActivityView;
import com.example.passion.src.SignIn.FindEmailInPw.interfaces.FindEmailInPwRetrofitInterface;
import com.example.passion.src.SignIn.FindEmailInPw.models.FindEmailInPwResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class FindEmailInPwService {
    private final FindEmailInPwActivityView mFindEmailInPwActivityView;

    public FindEmailInPwService(final FindEmailInPwActivityView findEmailInPwActivityView) {
        this.mFindEmailInPwActivityView = findEmailInPwActivityView;
    }

    //Post 로그인
    public void getFindEmailInPw(String email) {
        final FindEmailInPwRetrofitInterface findEmailInPwRetrofitInterface = getRetrofit().create(FindEmailInPwRetrofitInterface.class);
        findEmailInPwRetrofitInterface.getFindEmailInPw(email).enqueue(new Callback<FindEmailInPwResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<FindEmailInPwResponse> call, Response<FindEmailInPwResponse> response) {
                final FindEmailInPwResponse findEmailInPwResponse = response.body();
                if (findEmailInPwResponse == null) {//<설명> 응답 없음
                    mFindEmailInPwActivityView.FindEmailPwFailure(null);
                    return;
                } else if (findEmailInPwResponse.getCode() == 200) {//<설명> 계정 있음
                    mFindEmailInPwActivityView.FindEmailPwSuccess(findEmailInPwResponse.getMessage());
                } else {//<설명> 계정 없음
                    mFindEmailInPwActivityView.FindEmailPwFailure(findEmailInPwResponse.getMessage());
                }
            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<FindEmailInPwResponse> call, Throwable t) {
                mFindEmailInPwActivityView.FindEmailPwFailure(null);
            }
        });
    }

}
