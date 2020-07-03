package com.example.passion.src.TimerFragment.FragmentHome.statistics;

public class FragmentHomeData {
    private int ivPlay;
    private String tvSubject;
    private String tvTime;
    private int ivMenu;

    //<구현대상> 시간이 남으면 ivPlay의 tint 색 변경하기
    public FragmentHomeData(int ivPlay, String tvSubject, String tvTime, int ivMenu) {
        this.ivPlay = ivPlay;
        this.tvSubject = tvSubject;
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

    public String getTvSubject() {
        return tvSubject;
    }

    public void setTvSubject(String tvSubject) {
        this.tvSubject = tvSubject;
    }

    public String getTvTime() {
        return tvTime;
    }

    public void setTvTime(String tvTime) {
        this.tvTime = tvTime;
    }
}
