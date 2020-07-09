package com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog;

import com.example.passion.src.ApplicationClass;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.interfaces.RecycleMenuDialogActivityView;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.interfaces.RecycleMenuDialogRetrofitInterface;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.models.RecycleMenuDialogResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class RecycleMenuDialogService {
    private final RecycleMenuDialogActivityView mRecycleMenuDialogActivityView;

    public RecycleMenuDialogService(final RecycleMenuDialogActivityView recycleMenuDialogActivityView) {
        this.mRecycleMenuDialogActivityView = recycleMenuDialogActivityView;
    }

    //get 이메일 조회
    public void deleteSubject(String subjectName) {
        final RecycleMenuDialogRetrofitInterface recycleMenuDialogRetrofitInterface = getRetrofit().create(RecycleMenuDialogRetrofitInterface.class);
        //헤더 넣을때
        //ApplicationClass.sSharedPreferences.getString("X-ACCESS-TOKEN","")
        recycleMenuDialogRetrofitInterface.getSubject(ApplicationClass.X_ACCESS_TOKEN,subjectName).enqueue(new Callback<RecycleMenuDialogResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<RecycleMenuDialogResponse> call, Response<RecycleMenuDialogResponse> response) {
                final RecycleMenuDialogResponse recycleMenuDialogResponse = response.body();
                if (recycleMenuDialogResponse == null) {//<설명> 응답이 없을때
                    mRecycleMenuDialogActivityView.recycleMenuDialogFailure(null);
                    return;
                } else if (recycleMenuDialogResponse.getCode() == 200) {//<설명> 응답코드(200) : 로그인 성공
                    mRecycleMenuDialogActivityView.recycleMenuDialogSuccess(recycleMenuDialogResponse);
                } else {//<설명>응답코드(...) :로그인 실패
                    mRecycleMenuDialogActivityView.recycleMenuDialogFailure(recycleMenuDialogResponse.getMessage());
                }
            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<RecycleMenuDialogResponse> call, Throwable t) {
                mRecycleMenuDialogActivityView.recycleMenuDialogFailure(null);
            }
        });
    }
}
