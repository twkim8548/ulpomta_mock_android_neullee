package com.example.passion.src.TimerFragment.AddSubject;

import com.example.passion.src.TimerFragment.AddSubject.interfaces.AddSubjectActivityView;
import com.example.passion.src.TimerFragment.AddSubject.interfaces.AddSubjectRetrofitInterface;
import com.example.passion.src.TimerFragment.AddSubject.models.AddSubjectBody;
import com.example.passion.src.TimerFragment.AddSubject.models.AddSubjectResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class AddSubjectService {
    private final AddSubjectActivityView mAddSubjectActivityView;

    public AddSubjectService(final AddSubjectActivityView addSubjectActivityView) {
        this.mAddSubjectActivityView = addSubjectActivityView;
    }

    //Post 과목생성
    public void postAddSubject(String subjectName) {
        final AddSubjectRetrofitInterface addSubjectRetrofitInterface = getRetrofit().create(AddSubjectRetrofitInterface.class);
        addSubjectRetrofitInterface.addSubject(new AddSubjectBody(subjectName)).enqueue(new Callback<AddSubjectResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<AddSubjectResponse> call, Response<AddSubjectResponse> response) {
                final AddSubjectResponse addSubjectResponse = response.body();
                if (addSubjectResponse == null) {
                    mAddSubjectActivityView.validateFailure(null);
                    return;
                }

                mAddSubjectActivityView.addSubjectSuccess(addSubjectResponse.getCode());//반환값 : 코드(성공 200)

            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<AddSubjectResponse> call, Throwable t) {
                mAddSubjectActivityView.validateFailure(null);
            }
        });
    }

}
