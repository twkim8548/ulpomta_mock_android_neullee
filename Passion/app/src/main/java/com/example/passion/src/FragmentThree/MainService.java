package com.example.passion.src.FragmentThree;

import com.example.passion.src.FragmentThree.interfaces.FragThreeActivityView;

public class MainService {
    private final FragThreeActivityView mFragThreeActivityView;

    public MainService(final FragThreeActivityView fragThreeActivityView) {
        this.mFragThreeActivityView = fragThreeActivityView;
    }

//    public void getTest() {
//        final PalloSignInRetrofitInterface palloSignInRetrofitInterface = getRetrofit().create(PalloSignInRetrofitInterface.class);
//        palloSignInRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
//            @Override
//            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
//                final DefaultResponse defaultResponse = response.body();
//                if (defaultResponse == null) {
//                    mFragThreeActivityView.validateFailure(null);
//                    return;
//                }
//
//                mFragThreeActivityView.validateSuccess(defaultResponse.getMessage());
//            }
//
//            @Override
//            public void onFailure(Call<DefaultResponse> call, Throwable t) {
//                mFragThreeActivityView.validateFailure(null);
//            }
//        });
//    }
}
