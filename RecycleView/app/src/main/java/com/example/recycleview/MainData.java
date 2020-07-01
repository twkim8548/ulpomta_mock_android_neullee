package com.example.recycleview;

public class MainData {
    private int ivPlay;
    private String tvGoal;
    private String tvTime;
    private int ivMenu;

    public MainData(int ivPlay, String tvGoal, String tvTime, int ivMenu) {
        this.ivPlay = ivPlay;
        this.tvGoal = tvGoal;
        this.tvTime = tvTime;
        this.ivMenu = ivMenu;
    }

    public int getIvMenu() {
        return ivMenu;
    }

    public void setIvMenu(int ivMenu) {
        this.ivMenu = ivMenu;
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
