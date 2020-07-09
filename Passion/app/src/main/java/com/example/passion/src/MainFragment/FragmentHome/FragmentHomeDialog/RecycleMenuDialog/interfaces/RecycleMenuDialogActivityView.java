package com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.interfaces;

import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.models.RecycleMenuDialogResponse;

public interface RecycleMenuDialogActivityView {

    //[]배열 형태로 가져올때 > 전체 접근 > 그 안에서 사용할부분들을 꺼내오는 방식
    void recycleMenuDialogSuccess(RecycleMenuDialogResponse recycleMenuDialogResponse);

    void recycleMenuDialogFailure(String message);
}
