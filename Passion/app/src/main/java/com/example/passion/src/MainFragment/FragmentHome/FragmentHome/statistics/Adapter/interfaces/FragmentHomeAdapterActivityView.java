package com.example.passion.src.MainFragment.FragmentHome.FragmentHome.statistics.Adapter.interfaces;

public interface FragmentHomeAdapterActivityView {

    //[]배열 형태로 가져올때 > 전체 접근 > 그 안에서 사용할부분들을 꺼내오는 방식
    void fragmentHomeAdapterSuccess(int code);

    void fragmentHomeAdapterFailure(String message);
}
