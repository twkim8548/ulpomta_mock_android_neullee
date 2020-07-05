package com.example.passion.src.MainFragment.FragmentChart;

//3.어댑터에서 필요한 아이템을 하나의 객체로 만들어두기 위해 SingerItem 클래스를 정의
class FragmentChartItem {

    private String mDay;

    public FragmentChartItem(String mDay) {
        this.mDay = mDay;
    }

    public String getmDay() {
        return mDay;
    }

    public void setmDay(String mDay) {
        this.mDay = mDay;
    }
}
