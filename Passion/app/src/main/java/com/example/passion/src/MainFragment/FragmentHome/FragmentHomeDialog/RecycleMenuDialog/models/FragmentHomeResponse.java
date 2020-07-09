package com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FragmentHomeResponse {
    @SerializedName("total")
    private String total;

    @SerializedName("subjectTime")
    private List<SubjectTime> subjectTime;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public String getTotal() {
        return total;
    }

    public List<SubjectTime> getSubjectTime() {
        return subjectTime;
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