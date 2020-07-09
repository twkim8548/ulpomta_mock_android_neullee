package com.example.passion.src.MainFragment.FragmentChart.Calender.Day.models;

import com.google.gson.annotations.SerializedName;

public class FragmentCalenderDayResponse {
    @SerializedName("timeInfo")
    private TimeInfo timeInfo;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public TimeInfo getTimeInfo() {
        return timeInfo;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}