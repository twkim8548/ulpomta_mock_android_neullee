package com.example.passion.src.TimerFragment.AddSubject.models;

import com.google.gson.annotations.SerializedName;

public class AddSubjectBody {

    @SerializedName("name")
    private String name;

    public AddSubjectBody(String name) {
        this.name = name;
    }
}