package com.example.passion.src.MainFragment.FragmentChart;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.passion.R;
import com.example.passion.src.MainFragment.FragmentChart.Calender.Day.FragmentCalenderDay;
import com.example.passion.src.MainFragment.FragmentChart.Calender.FragmentChartAdapter;
import com.example.passion.src.MainFragment.FragmentChart.Calender.item_data;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FragmentChart extends Fragment implements ObservableScrollViewCallbacks {

    //<날짜>
    private TextView mTvDate;//년월 텍스트뷰
    public Calendar mCalendar;//캘린더 변수

    //<설명> 6.그리드뷰에서 어댑터를 사용해 목록을 생성하고 목록의 아이템을 클릭했을 때의 기능을 구현
    private FragmentChartAdapter gridAdapter;//그리드뷰 어뎁터
    private ArrayList<item_data> dayList;//일 저장할 리스트
    private GridView gridView;//그리드뷰

    //<하단 fragment>
    private TabLayout mTabLayout;
    private FragmentCalenderDay fragmentCalenderDay;//Fragment 일간

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //<설명> Fragment 화면 구성을 위한 세팅
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_chart, container, false);//<설명> setContentView와 같은 역할
        //<초기화>
        mTvDate = viewGroup.findViewById(R.id.tv_fragment_calender_year_month);
        gridView = viewGroup.findViewById(R.id.grid_fragment_chart);
        mTabLayout = viewGroup.findViewById(R.id.tab_timer_main);

        //<프래그먼트 세팅
        final FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();//프래그먼트 사용을 위해 세팅
        //초기값 세팅
        fragmentCalenderDay = new FragmentCalenderDay();
        transaction.add(R.id.frame_layout_fragment_chart, fragmentCalenderDay).commit();
        //TabLayout에 목록 세팅
//        mTabLayout.addTab(mTabLayout.newTab().setText("일간"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("주간"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("월간"));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                final FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                int position = tab.getPosition();
                switch (position) {
                    case 0://일간
                        transaction.replace(R.id.frame_layout_fragment_chart, fragmentCalenderDay).commit();
                        break;
                    case 1:
                        transaction.replace(R.id.frame_layout_fragment_chart, fragmentCalenderDay).commit();//내용바꾸기
                        break;
                    case 2:
                        transaction.replace(R.id.frame_layout_fragment_chart, fragmentCalenderDay).commit();//내용바꾸기
                        break;
                    default:
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });


        //<이번 년도와 월 세팅>
        // 오늘에 날짜를 세팅 해준다.
        long now = System.currentTimeMillis();
        final Date date = new Date(now);
        //연,월,일을 따로 저장
        final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        final SimpleDateFormat curMonthFormat = new SimpleDateFormat("M", Locale.KOREA);
        final SimpleDateFormat curToDayFormat = new SimpleDateFormat("d", Locale.KOREA);
        String checkToday = curToDayFormat.format(date);//오늘날짜 확인
        mTvDate.setText(curYearFormat.format(date) + "년 " + curMonthFormat.format(date) + "월");
        //<날짜 달력 요일 표시>
        //gridview 요일 표시
        dayList = new ArrayList<item_data>();
        //캘린더 사용
        mCalendar = Calendar.getInstance();
        //이번달 1일 무슨요일인지 판단 mCal.set(Year,Month,Day)
        mCalendar.set(Integer.parseInt(curYearFormat.format(date)), Integer.parseInt(curMonthFormat.format(date)) - 1, 1);
        int dayNum = mCalendar.get(Calendar.DAY_OF_WEEK);
        //1일 - 요일 매칭 시키기 위해 공백 add
        for (int i = 1; i < dayNum; i++) {
            dayList.add(new item_data("", false));
        }
        //달력에 날짜 세팅
        setCalendarDate(mCalendar.get(Calendar.MONTH) + 1);
        //오늘날짜인 경우 true로 바꾸어서 레이아웃을 세팅한다
        for (int i = 0; i < dayList.size(); i++) {
            if (checkToday.equals(dayList.get(i).getDay())) {
                dayList.get(i).setChecked(true);
                break;
            }
        }


        //날짜를 그리드뷰에 연결함
        gridAdapter = new FragmentChartAdapter(viewGroup.getContext(), dayList);
        gridView.setAdapter(gridAdapter);
        //날짜 선택시 나오는 화면
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), dayList.get(position).getDay() + "선택", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < dayList.size(); i++) {
                    if (i == position) {
                        dayList.get(position).setChecked(true);
                    } else {
                        dayList.get(i).setChecked(false);
                    }
                }
                gridAdapter.notifyDataSetChanged();//클릭 될때마다 데이터를 notify 진행
            }
        });

        return viewGroup;
    }


    //<기능>해당 월에 표시할 일 수 구함
    private void setCalendarDate(int month) {
        mCalendar.set(Calendar.MONTH, month - 1);
        for (int i = 0; i < mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            dayList.add(new item_data("" + (i + 1), false));
        }
    }

    //observableListView 애니메이션
    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {

    }


    //ObservableListView - 작동을 안한다..
    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        ActionBar ab = ((AppCompatActivity) getActivity()).getActionBar();//엑티비티 : getActionBar(); 적용

        if (scrollState == ScrollState.UP) {
            if (ab.isShowing()) {
                ab.hide();
            }
        } else if (scrollState == ScrollState.DOWN) {
            if (!ab.isShowing()) {
                ab.show();
            }

        }
    }
}