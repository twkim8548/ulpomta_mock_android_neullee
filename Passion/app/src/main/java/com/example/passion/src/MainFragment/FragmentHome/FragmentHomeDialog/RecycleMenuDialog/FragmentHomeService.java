package com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog;

import com.example.passion.src.ApplicationClass;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.interfaces.FragmentHomeActivityView;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.interfaces.FragmentHomeRetrofitInterface;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.models.FragmentHomeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class FragmentHomeService {
    private final FragmentHomeActivityView mFragmentHomeActivityView;

    public FragmentHomeService(final FragmentHomeActivityView fragmentHomeActivityView) {
        this.mFragmentHomeActivityView = fragmentHomeActivityView;
    }

    //get 이메일 조회
    public void getSubject() {
        final FragmentHomeRetrofitInterface fragmentHomeRetrofitInterface = getRetrofit().create(FragmentHomeRetrofitInterface.class);
        //헤더 넣을때
        //ApplicationClass.sSharedPreferences.getString("X-ACCESS-TOKEN","")
        fragmentHomeRetrofitInterface.getSubject(ApplicationClass.X_ACCESS_TOKEN).enqueue(new Callback<FragmentHomeResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<FragmentHomeResponse> call, Response<FragmentHomeResponse> response) {
                final FragmentHomeResponse fragmentHomeResponse = response.body();
                if (fragmentHomeResponse == null) {//<설명> 응답이 없을때
                    mFragmentHomeActivityView.fragmentHomeFailure(null);
                    return;
                } else if (fragmentHomeResponse.getCode() == 200) {//<설명> 응답코드(200) : 로그인 성공
                    mFragmentHomeActivityView.fragmentHomeSuccess(fragmentHomeResponse);
                } else {//<설명>응답코드(...) :로그인 실패
                    mFragmentHomeActivityView.fragmentHomeFailure(fragmentHomeResponse.getMessage());
                }
            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<FragmentHomeResponse> call, Throwable t) {
                mFragmentHomeActivityView.fragmentHomeFailure(null);
            }
        });
    }
}
