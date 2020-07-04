package com.example.passion.src.MainFragment.FragmentHome.AddSubject.models;

import com.google.gson.annotations.SerializedName;

public class AddSubjectBody {

    @SerializedName("subjectName")
    private String subjectName;

    public AddSubjectBody(String subjectName) {
        this.subjectName = subjectName;
    }
}