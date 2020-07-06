package com.example.passion.src.Timer.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.passion.src.Timer.FragmentCheckBox.FragmentCheckBox;
import com.example.passion.src.Timer.FragmentDictionary.FragmentDictionary;
import com.example.passion.src.Timer.FragmentGrid.FragmentGrid;
import com.example.passion.src.Timer.FragmentTimer.FragmentTimer;
import com.example.passion.src.Timer.FragmnetMenuHoriz.FragmentMenuHoriz;
import com.example.passion.src.Timer.FramentPeople.FragmentPeople;

public class TimerAdapter extends FragmentPagerAdapter {

    //TabLayout의 카운트
    private int tabCount;

    //생성자 - Fragment를 관리하는 권한 / TabLayout의 선택갯수
    public TimerAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentPeople fragmentPeople = new FragmentPeople();
                return fragmentPeople;

            case 1:
                FragmentCheckBox fragmentCheckBox = new FragmentCheckBox();
                return fragmentCheckBox;

            case 2:
                FragmentGrid fragmentGrid = new FragmentGrid();
                return fragmentGrid;

            case 3:
                FragmentDictionary fragmentDictionary = new FragmentDictionary();
                return fragmentDictionary;

            case 4:
                FragmentTimer fragmentTimer = new FragmentTimer();
                return fragmentTimer;

            case 5:
                FragmentMenuHoriz fragmentMenuHoriz = new FragmentMenuHoriz();
                return fragmentMenuHoriz;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
