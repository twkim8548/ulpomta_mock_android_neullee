package com.example.passion.src.Access.FragmentThree;

import com.example.passion.src.Access.FragmentThree.interfaces.FragThreeActivityView;

public class FragThreeService {
    private final FragThreeActivityView mFragThreeActivityView;

    public FragThreeService(final FragThreeActivityView fragThreeActivityView) {
        this.mFragThreeActivityView = fragThreeActivityView;
    }

//    public void getTest() {
//        final PalloFIndPWRetrofitInterface palloSignInRetrofitInterface = getRetrofit().create(PalloFIndPWRetrofitInterface.class);
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
