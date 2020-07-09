package com.example.passion.src.SignIn.FindEmailDialog;

import com.example.passion.src.SignIn.FindEmailDialog.interfaces.FindEmailDialogActivityView;
import com.example.passion.src.SignIn.FindEmailDialog.interfaces.FindEmailDialogRetrofitInterface;
import com.example.passion.src.SignIn.FindEmailDialog.models.FindEmailDialogResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class FindEmailDialogService {
    private final FindEmailDialogActivityView mFindEmailDialogActivityView;

    public FindEmailDialogService(final FindEmailDialogActivityView findEmailDialogActivityView) {
        this.mFindEmailDialogActivityView = findEmailDialogActivityView;
    }

    //Post 로그인
    public void getSingInStartDialog(String nickname) {
        final FindEmailDialogRetrofitInterface findEmailDialogRetrofitInterface = getRetrofit().create(FindEmailDialogRetrofitInterface.class);
        findEmailDialogRetrofitInterface.getEmail(nickname).enqueue(new Callback<FindEmailDialogResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<FindEmailDialogResponse> call, Response<FindEmailDialogResponse> response) {
                final FindEmailDialogResponse findEmailDialogResponse = response.body();
                if (findEmailDialogResponse == null) {//<설명> 응답이 없을때
                    mFindEmailDialogActivityView.signInStartDialogFailure(null);
                    return;
                } else if (findEmailDialogResponse.getCode() == 200) {//<설명> 응답코드(200) : 로그인 성공
                    mFindEmailDialogActivityView.signInStartDialogSuccess(findEmailDialogResponse.getUserInfo());
                } else {//<설명>응답코드(...) :로그인 실패
                    mFindEmailDialogActivityView.signInStartDialogFailure(findEmailDialogResponse.getUserInfo());
                }
            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<FindEmailDialogResponse> call, Throwable t) {
                mFindEmailDialogActivityView.signInStartDialogFailure(null);
            }
        });
    }

}
