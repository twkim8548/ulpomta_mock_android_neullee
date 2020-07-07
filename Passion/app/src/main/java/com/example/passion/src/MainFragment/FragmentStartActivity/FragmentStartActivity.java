package com.example.passion.src.MainFragment.FragmentStartActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;
import com.example.passion.src.MainFragment.FragmentChart.FragmentChart;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHome.FragmentHome;
import com.example.passion.src.MainFragment.FragmentPlanner.FragmentPlanner;
import com.example.passion.src.MainFragment.FragmentRank.FragmentRank;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentStartActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FragmentHome fragmentHome;
    FragmentChart fragmentChart;
    FragmentPlanner fragmentPlanner;
    FragmentRank fragmentRank;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_start);
        //초기화
        bottomNavigationView = findViewById(R.id.btnNavigation_main);

        //프래그먼트 생성
        fragmentHome = new FragmentHome();
        fragmentChart = new FragmentChart();
        fragmentPlanner = new FragmentPlanner();
        fragmentRank = new FragmentRank();

        //제일 처름 띄워줄 뷰 세팅 (commit();까지 해줘야함)
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, fragmentHome).commitAllowingStateLoss();

        //버튼 네비게이션 초기 선택 값
        bottomNavigationView.setSelectedItemId(R.id.ic_main_home);

        //버튼네비게이션 아이콘을 선택했을때 원하는 프래그먼트가 띄워질 수 있도록 리스너 구현
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
//                    <완료>ic_main_chart
//                    <완료>ic_main_planner
//                    <완료> ic_main_home
//                    <완료> ic_main_rank
//                    ic_main_group
                    case R.id.ic_main_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, fragmentHome).commitAllowingStateLoss();
                        return true;

                    case R.id.ic_main_chart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main,fragmentChart).commitAllowingStateLoss();
                        return true;

                    case R.id.ic_main_planner:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main,fragmentPlanner).commitAllowingStateLoss();
                        return true;

                    case R.id.ic_main_rank:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, fragmentRank).commitAllowingStateLoss();
                        return true;


                    default:
                        return true;
                }
            }
        });
    }

}
