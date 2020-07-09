package com.example.passion.src.MainFragment.FragmentChart.Calender.Day;

import com.example.passion.src.ApplicationClass;
import com.example.passion.src.MainFragment.FragmentChart.Calender.Day.interfaces.FragmentCalenderDayActivityView;
import com.example.passion.src.MainFragment.FragmentChart.Calender.Day.interfaces.FragmentCalenderDayRetrofitInterface;
import com.example.passion.src.MainFragment.FragmentChart.Calender.Day.models.FragmentCalenderDayResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class FragmentCalenderDayService {
    private final FragmentCalenderDayActivityView mFragmentCalenderDayActivityView;

    public FragmentCalenderDayService(final FragmentCalenderDayActivityView mFragmentCalenderDayActivityView) {
        this.mFragmentCalenderDayActivityView = mFragmentCalenderDayActivityView;
    }

    //get 이메일 조회
    public void getDailyTime(int year, int month, int day) {
        final FragmentCalenderDayRetrofitInterface fragmentCalenderDayRetrofitInterface = getRetrofit().create(FragmentCalenderDayRetrofitInterface.class);
        //헤더 넣을때
        //ApplicationClass.sSharedPreferences.getString("X-ACCESS-TOKEN","")
        fragmentCalenderDayRetrofitInterface.getSubject(ApplicationClass.X_ACCESS_TOKEN,year,month,day).enqueue(new Callback<FragmentCalenderDayResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<FragmentCalenderDayResponse> call, Response<FragmentCalenderDayResponse> response) {
                final FragmentCalenderDayResponse fragmentCalenderDayResponse = response.body();
                if (fragmentCalenderDayResponse == null) {//<설명> 응답이 없을때
                    mFragmentCalenderDayActivityView.fragmentCalenderDayFailure(null);
                    return;
                } else if (fragmentCalenderDayResponse.getCode() == 200) {//<설명> 응답코드(200) : 로그인 성공
                    mFragmentCalenderDayActivityView.fragmentCalenderDaySuccess(fragmentCalenderDayResponse.getTimeInfo());
                } else {//<설명>응답코드(...) :로그인 실패
                    mFragmentCalenderDayActivityView.fragmentCalenderDayFailure(fragmentCalenderDayResponse.getMessage());
                }
            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<FragmentCalenderDayResponse> call, Throwable t) {
                mFragmentCalenderDayActivityView.fragmentCalenderDayFailure(null);
            }
        });
    }
}
