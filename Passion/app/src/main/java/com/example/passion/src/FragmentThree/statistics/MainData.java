package com.example.passion.src.FragmentThree.statistics;

public class MainData {
    private int ivPlay;
    private String tvGoal;
    private String tvTime;

    public MainData(int ivPlay, String tvGoal, String tvTime) {
        this.ivPlay = ivPlay;
        this.tvGoal = tvGoal;
        this.tvTime = tvTime;
    }

    public int getIvPlay() {
        return ivPlay;
    }

    public void setIvPlay(int ivPlay) {
        this.ivPlay = ivPlay;
    }

    public String getTvGoal() {
        return tvGoal;
    }

    public void setTvGoal(String tvGoal) {
        this.tvGoal = tvGoal;
    }

    public String getTvTime() {
        return tvTime;
    }

    public void setTvTime(String tvTime) {
        this.tvTime = tvTime;
    }
}
