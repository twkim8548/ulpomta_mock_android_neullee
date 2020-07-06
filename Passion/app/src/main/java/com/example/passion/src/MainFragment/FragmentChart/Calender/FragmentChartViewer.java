package com.example.passion.src.MainFragment.FragmentChart.Calender;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.passion.R;

//2. 데이터 아이템을 위한 뷰의 기능을 정의할 클래스를 설계
public class FragmentChartViewer extends LinearLayout {

    TextView mTvday;

    public FragmentChartViewer(Context context) {
        super(context);
        init(context);
    }
    //init <역할>
    //SingerViwer 객체(데이터 아이템 뷰)가 생성되면서 호출되는 초기화를 위한 메소드로
    //(ex) singeritem.xml 레이아웃과 인플레이션을 해줍니다.
    // 또한 뷰에서 사용할 텍스트의 id 값을 찾아줍니다.

    public FragmentChartViewer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_fragment_chart, this, true);

        mTvday = findViewById(R.id.tv_fragment_chart_day);
    }

    //어댑터에서 선택 위젯에 SingerViwer 객체를 띄우기 위해 호출되는 메소드로 SIngerItem 객체의 데이터를 각 텍스트뷰와 이미지뷰에 띄워주는 역할
    public void setItem(FragmentChartItem fragmentChartItem) {
        mTvday.setText(fragmentChartItem.getmDay());
    }


}
