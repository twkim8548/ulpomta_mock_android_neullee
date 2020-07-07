package com.example.passion.src.MainFragment.FragmentHome.ToolBar.Ddays;

public class DdaysData {

    private String mEnterContents;
    private String mEnterDays;
    private String mDate;
    private int mIvMenu;

    public DdaysData(String mEnterContents, String mEnterDays, String mDate, int mIvMenu) {
        this.mEnterContents = mEnterContents;
        this.mEnterDays = mEnterDays;
        this.mDate = mDate;
        this.mIvMenu = mIvMenu;
    }

    public String getmEnterContents() {
        return mEnterContents;
    }

    public void setmEnterContents(String mEnterContents) {
        this.mEnterContents = mEnterContents;
    }

    public String getmEnterDays() {
        return mEnterDays;
    }

    public void setmEnterDays(String mEnterDays) {
        this.mEnterDays = mEnterDays;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public int getmIvMenu() {
        return mIvMenu;
    }

    public void setmIvMenu(int mIvMenu) {
        this.mIvMenu = mIvMenu;
    }
}
