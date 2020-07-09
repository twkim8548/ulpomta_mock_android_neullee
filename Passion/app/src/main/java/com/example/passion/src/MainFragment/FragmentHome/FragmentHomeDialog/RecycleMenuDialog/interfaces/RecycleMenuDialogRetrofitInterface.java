package com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.interfaces;

import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.models.RecycleMenuDialogResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RecycleMenuDialogRetrofitInterface {
    //Delet와 get은 바디가 없다
    @DELETE("/sub")
    Call<RecycleMenuDialogResponse> getSubject(
            @Header("X-Access-Token") String jwt,
            @Query("subjectName")  String subjectName
        );
}
