package com.example.passion.src.MainFragment.FragmentHome;

import com.example.passion.src.MainFragment.FragmentHome.interfaces.FragmentHomeActivityView;

public class FragmentHomeService {
    private final FragmentHomeActivityView mFragmentHomeActivityView;

    public FragmentHomeService(final FragmentHomeActivityView fragmentHomeActivityView) {
        this.mFragmentHomeActivityView = fragmentHomeActivityView;
    }

//    public void getTest() {
//        final FindEmailInPwRetrofitInterface palloSignInRetrofitInterface = getRetrofit().create(FindEmailInPwRetrofitInterface.class);
//        palloSignInRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
//            @Override
//            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
//                final DefaultResponse defaultResponse = response.body();
//                if (defaultResponse == null) {
//                    mFragmentHomeActivityView.validateFailure(null);
//                    return;
//                }
//
//                mFragmentHomeActivityView.validateSuccess(defaultResponse.getMessage());
//            }
//
//            @Override
//            public void onFailure(Call<DefaultResponse> call, Throwable t) {
//                mFragmentHomeActivityView.validateFailure(null);
//            }
//        });
//    }
}
