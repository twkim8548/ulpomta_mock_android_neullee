package com.example.passion.src.MainFragment.FragmentChart.Calender.Day.interfaces;

import com.example.passion.src.MainFragment.FragmentChart.Calender.Day.models.FragmentCalenderDayResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface FragmentCalenderDayRetrofitInterface {
    @GET("/timestat/daily")
    Call<FragmentCalenderDayResponse> getSubject(
            @Header("X-Access-Token") String jwt,
            @Query("year") int year,
            @Query("month") int month,
            @Query("day") int day
    );
}
