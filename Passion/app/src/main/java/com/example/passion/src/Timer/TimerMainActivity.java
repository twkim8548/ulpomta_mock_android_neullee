package com.example.passion.src.Timer;

import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.passion.R;
import com.example.passion.src.Timer.Adapter.TimerAdapter;
import com.google.android.material.tabs.TabLayout;

public class TimerMainActivity extends AppCompatActivity{

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Chronometer mChronometerMain,mChronometerSubject,mChronometerCurTime;
    private long mTimeSaveMain,mTimeSaveSubject;
    private boolean mFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_main);

        mTabLayout = findViewById(R.id.tab_timer_main);

        mViewPager = findViewById(R.id.vp_timer_main);

        TimerAdapter timerAdapter = new TimerAdapter(getSupportFragmentManager(),mTabLayout.getTabCount());
        mViewPager.setAdapter(timerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //viewPager 연결
                mViewPager.setCurrentItem(tab.getPosition());
                int tabIconColor = ContextCompat.getColor(getBaseContext(),R.color.colorWhite);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(getBaseContext(),R.color.colorTabIconBefore);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        //시간 불러오기
        SharedPreferences spf = getSharedPreferences("saveTime",MODE_PRIVATE);
        mTimeSaveMain = spf.getLong("mTimeSaveMain",0);
        mTimeSaveSubject = spf.getLong("mTimeSaveSubject",0);

        //Chronometer 세팅
        mFlag = false;//Choronometer 시간 멈춤을 위한 flag
        mChronometerMain = findViewById(R.id.chronometer_main);
        mChronometerSubject = findViewById(R.id.chronometer_subject);
        mChronometerCurTime = findViewById(R.id.chronometer_cur_time);

        mChronometerMain.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                int h = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                int s = (int)(time - h*3600000- m*60000)/1000 ;
                String t = (h < 10 ? "0"+h: h)+ ":" +(m < 10 ? "0"+m: m)+ ":" + (s < 10 ? "0"+s: s);
                chronometer.setText(t);
            }
        });
        mChronometerMain.setBase(SystemClock.elapsedRealtime()+mTimeSaveMain);
        mChronometerMain.setText("00:00:00");
        mChronometerMain.start();


        mChronometerSubject.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                int h = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                int s = (int)(time - h*3600000- m*60000)/1000 ;
                String t = (h < 10 ? "0"+h: h)+ ":" +(m < 10 ? "0"+m: m)+ ":" + (s < 10 ? "0"+s: s);
                chronometer.setText(t);
            }
        });
        mChronometerSubject.setBase(SystemClock.elapsedRealtime()+mTimeSaveSubject);
        mChronometerSubject.setText("00:00:00");
        mChronometerSubject.start();


        mChronometerCurTime.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                int h = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                int s = (int)(time - h*3600000- m*60000)/1000 ;
                String t = (h < 10 ? "0"+h: h)+ ":" +(m < 10 ? "0"+m: m)+ ":" + (s < 10 ? "0"+s: s);
                chronometer.setText(t);
            }
        });
        mChronometerCurTime.setBase(SystemClock.elapsedRealtime());
        mChronometerCurTime.setText("00:00:00");
        mChronometerCurTime.start();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mChronometerMain.start();
        mChronometerSubject.start();
        mChronometerCurTime.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!mFlag){
            //현재 멈추는 시간 세팅
            mChronometerMain.stop();
            mChronometerSubject.stop();
            mChronometerCurTime.stop();
            //onPause의 플래그
            mFlag = true;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimeSaveMain = mChronometerMain.getBase() - SystemClock.elapsedRealtime();
        mTimeSaveSubject = mChronometerSubject.getBase() - SystemClock.elapsedRealtime();
        SharedPreferences spf = getSharedPreferences("saveTime",MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.putLong("mTimeSaveMain",mTimeSaveMain);
        editor.putLong("mTimeSaveSubject",mTimeSaveSubject);
        editor.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
    }

}
