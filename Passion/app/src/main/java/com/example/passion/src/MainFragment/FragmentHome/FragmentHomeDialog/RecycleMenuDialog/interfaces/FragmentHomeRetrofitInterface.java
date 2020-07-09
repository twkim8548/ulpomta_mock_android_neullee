package com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.interfaces;

import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.models.FragmentHomeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface FragmentHomeRetrofitInterface {
    @GET("/home")
    Call<FragmentHomeResponse> getSubject(
            @Header("X-Access-Token") String jwt
//            @Query("content") final SubjectTime content
    );
}
