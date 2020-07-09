package com.example.passion.src.MainFragment.FragmentChart.Calender.Day.interfaces;

import com.example.passion.src.MainFragment.FragmentChart.Calender.Day.models.TimeInfo;

public interface FragmentCalenderDayActivityView {

    //[]배열 형태로 가져올때 > 전체 접근 > 그 안에서 사용할부분들을 꺼내오는 방식
    void fragmentCalenderDaySuccess(TimeInfo timeInfo);

    void fragmentCalenderDayFailure(String message);
}
