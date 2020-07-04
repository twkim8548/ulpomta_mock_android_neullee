package com.example.passion.src.MainFragment.FragmentHome.AddSubject.interfaces;

import com.example.passion.src.MainFragment.FragmentHome.AddSubject.models.AddSubjectBody;
import com.example.passion.src.MainFragment.FragmentHome.AddSubject.models.AddSubjectResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AddSubjectRetrofitInterface {
    @POST("/sub")
    Call<AddSubjectResponse> addSubject(@Body AddSubjectBody params);
}
