package com.example.passion.src.MainFragment.FragmentChart.Calender.Day.models;

import com.google.gson.annotations.SerializedName;

public class TimeInfo {

    @SerializedName("sect")
    private int sect;

    @SerializedName("total")
    private String total;

    @SerializedName("max")
    private String max;

    @SerializedName("start")
    private String start;

    @SerializedName("finish")
    private String finish;

    public int getSect() {
        return sect;
    }

    public String getTotal() {
        return total;
    }

    public String getMax() {
        return max;
    }

    public String getStart() {
        return start;
    }

    public String getFinish() {
        return finish;
    }
}
