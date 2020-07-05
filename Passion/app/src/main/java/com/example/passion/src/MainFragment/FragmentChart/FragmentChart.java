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

import com.example.passion.R;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FragmentChart extends Fragment implements ObservableScrollViewCallbacks {

    //    private Activity activity;
    private TextView mTvDate;//년월 텍스트뷰
    public Calendar mCalendar;//캘린더 변수

    //<설명> 6.그리드뷰에서 어댑터를 사용해 목록을 생성하고 목록의 아이템을 클릭했을 때의 기능을 구현
    private FragmentChartAdapter gridAdapter;//그리드뷰 어뎁터

    private ArrayList<item_data> dayList;//일 저장할 리스트
    private GridView gridView;//그리드뷰


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //<설명> Fragment 화면 구성을 위한 세팅
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_chart, container, false);//<설명> setContentView와 같은 역할
        mTvDate = viewGroup.findViewById(R.id.tv_fragment_calender_year_month);
        gridView = viewGroup.findViewById(R.id.grid_fragment_chart);
        //ObservableScrollView / ObservableListView
//        ObservableScrollView observableScrollView = viewGroup.findViewById(R.id.observable_fragment_chart);
//        observableScrollView.setScrollViewCallbacks(this);
// Add these codes after ListView initialization
//        ArrayList<String> items = new ArrayList<String>();
//        for (int i = 1; i <= 100; i++) {
//            items.add("Item " + i);
//        }
//        observableListlView.setAdapter(new ArrayAdapter<String>(viewGroup.getContext(), android.R.layout.simple_list_item_1, items));


        //<이번 년도와 월 세팅>
        // 오늘에 날짜를 세팅 해준다.
        long now = System.currentTimeMillis();
        final Date date = new Date(now);
        //연,월,일을 따로 저장
        final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        final SimpleDateFormat curMonthFormat = new SimpleDateFormat("M", Locale.KOREA);
        mTvDate.setText(curYearFormat.format(date) + "년 " + curMonthFormat.format(date) + "월");

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
        setCalendarDate(mCalendar.get(Calendar.MONTH) + 1);

        gridAdapter = new FragmentChartAdapter(viewGroup.getContext(), dayList);
        gridView.setAdapter(gridAdapter);

        //오늘날짜인지 확인한다




        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), position + "선택", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < dayList.size(); i++) {
                    if (i == position) {
                        dayList.get(position).setChecked(true);
                    } else {
                        dayList.get(i).setChecked(false);
                    }

                }
                gridAdapter.notifyDataSetChanged();
            }
        });


        return viewGroup;
    }


    //<기능>해당 월에 표시할 일 수 구함
    private void setCalendarDate(int month) {
        mCalendar.set(Calendar.MONTH, month - 1);
        for (int i = 0; i < mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            dayList.add(new item_data("" + (i + 1),false));
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