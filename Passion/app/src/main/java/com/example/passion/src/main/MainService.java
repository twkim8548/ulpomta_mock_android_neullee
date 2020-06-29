package com.example.passion.src.main;

import com.example.passion.src.main.models.DefaultResponse;
import com.softsquared.template.src.main.MainActivity;
import com.softsquared.template.src.main.interfaces.MainActivityView;
import com.softsquared.template.src.main.interfaces.MainRetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

public class MainService {
    private final MainActivityView mMainActivityView;

    public MainService(final MainActivity mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }

    public void getTest() {
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        mainRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mMainActivityView.validateFailure(null);
                    return;
                }

                mMainActivityView.validateSuccess(defaultResponse.getMessage());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mMainActivityView.validateFailure(null);
            }
        });
    }
}
