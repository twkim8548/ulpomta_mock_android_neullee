package com.example.passion.src.TimerFragment.AddSubject.interfaces;

import com.example.passion.src.TimerFragment.AddSubject.models.AddSubjectBody;
import com.example.passion.src.TimerFragment.AddSubject.models.AddSubjectResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AddSubjectRetrofitInterface {
    @POST("/sub")
    Call<AddSubjectResponse> addSubject(@Body AddSubjectBody params);
}
