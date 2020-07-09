package com.example.passion.src.MainFragment.FragmentHome.FragmentHome.statistics.Adapter.interfaces;

import com.example.passion.src.MainFragment.FragmentHome.FragmentHome.statistics.Adapter.models.FragmentHomeAdapterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface FragmentHomeAdapterRetrofitInterface {


    @POST("/timecheck/start")
    Call<FragmentHomeAdapterResponse> postTimeCheck(
            @Header("X-Access-Token") String jwt,
            @Body int subjectId
            );
}
