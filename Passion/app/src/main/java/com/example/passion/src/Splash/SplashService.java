package com.example.passion.src.Splash;

import com.example.passion.src.Splash.interfaces.SplashActivityView;
import com.example.passion.src.Splash.interfaces.SplashRetrofitInterface;
import com.example.passion.src.Splash.models.InfoResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class SplashService {
    private SplashActivityView mSplashActivityView;

    public SplashService(final SplashActivityView mSplashActivityView) {
        this.mSplashActivityView = mSplashActivityView;
    }

    //Post 로그인
    public void getCheckJwt() {
        final SplashRetrofitInterface splashRetrofitInterface = getRetrofit().create(SplashRetrofitInterface.class);
        splashRetrofitInterface.checkJwt().enqueue(new Callback<InfoResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                final InfoResponse infoResponse = response.body();
                if (infoResponse == null) {//<설명> 응답이 없을때
                    mSplashActivityView.checkJwtFailure(null);
                    return;
                } else if (infoResponse.getCode() == 200) {//<설명> 응답코드(200) : 로그인 성공
                    mSplashActivityView.checkJwtSuccess(infoResponse.getCode());
                } else {//<설명>응답코드(...) :로그인 실패
                    mSplashActivityView.checkJwtFailure(infoResponse.getMessage());
                }
            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<InfoResponse> call, Throwable t) {
                mSplashActivityView.checkJwtFailure(null);
            }
        });
    }

}
