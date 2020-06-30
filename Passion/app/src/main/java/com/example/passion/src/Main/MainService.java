package com.example.passion.src.Main;

import com.example.passion.src.pallomain.interfaces.MainActivityView;
import com.example.passion.src.pallomain.interfaces.MainRetrofitInterface;
import com.example.passion.src.pallomain.models.DefaultResponse;
import com.example.passion.src.pallomain.statistics.PalloMainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class MainService {
    private final MainActivityView mMainActivityView;

    public MainService(final PalloMainActivity palloMainActivityView) {
        this.mMainActivityView = palloMainActivityView;
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
