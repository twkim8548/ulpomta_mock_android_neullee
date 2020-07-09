package com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.interfaces;

import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.models.FragmentHomeResponse;

public interface FragmentHomeActivityView {

    //[]배열 형태로 가져올때 > 전체 접근 > 그 안에서 사용할부분들을 꺼내오는 방식
    void fragmentHomeSuccess(FragmentHomeResponse fragmentHomeResponse);

    void fragmentHomeFailure(String message);
}
