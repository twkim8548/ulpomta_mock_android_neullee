package com.example.passion.src.MainFragment.FragmentHome.FragmentHome.statistics.Adapter;

import com.example.passion.src.ApplicationClass;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHome.statistics.Adapter.interfaces.FragmentHomeAdapterActivityView;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHome.statistics.Adapter.interfaces.FragmentHomeAdapterRetrofitInterface;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHome.statistics.Adapter.models.FragmentHomeAdapterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class FragmentHomeAdapterService {
    private final FragmentHomeAdapterActivityView mFragmentHomeAdapterActivityView;

    public FragmentHomeAdapterService(final FragmentHomeAdapterActivityView fragmentHomeAdapterActivityView) {
        this.mFragmentHomeAdapterActivityView = fragmentHomeAdapterActivityView;
    }

    //get 이메일 조회
    public void getSubject(int subjectId) {
        final FragmentHomeAdapterRetrofitInterface fragmentHomeAdapterRetrofitInterface = getRetrofit().create(FragmentHomeAdapterRetrofitInterface.class);
        //헤더 넣을때
        //ApplicationClass.sSharedPreferences.getString("X-ACCESS-TOKEN","")
        fragmentHomeAdapterRetrofitInterface.postTimeCheck(ApplicationClass.X_ACCESS_TOKEN,subjectId).enqueue(new Callback<FragmentHomeAdapterResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<FragmentHomeAdapterResponse> call, Response<FragmentHomeAdapterResponse> response) {
                final FragmentHomeAdapterResponse fragmentHomeAdapterResponse = response.body();
                if (fragmentHomeAdapterResponse == null) {//<설명> 응답이 없을때
                    mFragmentHomeAdapterActivityView.fragmentHomeAdapterFailure(null);
                    return;
                } else if (fragmentHomeAdapterResponse.getCode() == 200) {//<설명> 응답코드(200) : 로그인 성공
                    mFragmentHomeAdapterActivityView.fragmentHomeAdapterSuccess(fragmentHomeAdapterResponse.getCode());
                } else {//<설명>응답코드(...) :로그인 실패
                    mFragmentHomeAdapterActivityView.fragmentHomeAdapterFailure(fragmentHomeAdapterResponse.getMessage());
                }
            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<FragmentHomeAdapterResponse> call, Throwable t) {
                mFragmentHomeAdapterActivityView.fragmentHomeAdapterFailure(null);
            }
        });
    }
}
