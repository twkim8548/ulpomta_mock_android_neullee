package com.example.passion.src.MainFragment.FragmentChart;

public class item_data {
    String day;
    boolean isChecked;

    public item_data(String day, boolean isChecked) {
        this.day = day;
        this.isChecked = isChecked;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
