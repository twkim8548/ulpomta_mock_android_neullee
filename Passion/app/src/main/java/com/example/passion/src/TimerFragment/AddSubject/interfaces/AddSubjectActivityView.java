package com.example.passion.src.TimerFragment.AddSubject.interfaces;

public interface AddSubjectActivityView {

    void validateFailure(String message);

    void addSubjectSuccess(int code);//코드 (200 : 성공)
}
