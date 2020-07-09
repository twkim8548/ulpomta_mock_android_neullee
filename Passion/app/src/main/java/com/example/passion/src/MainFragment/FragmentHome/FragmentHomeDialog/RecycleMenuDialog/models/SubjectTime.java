package com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.models;

import com.google.gson.annotations.SerializedName;

public class SubjectTime {

    @SerializedName("idx")
    private int idx;

    @SerializedName("subject")
    private String subject;

    @SerializedName("time")
    private String time;

    public int getIdx() {
        return idx;
    }

    public String getSubject() {
        return subject;
    }

    public String getTime() {
        return time;
    }
}
