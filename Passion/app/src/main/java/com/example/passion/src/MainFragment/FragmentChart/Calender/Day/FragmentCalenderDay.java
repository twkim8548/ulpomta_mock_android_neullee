package com.example.passion.src.MainFragment.FragmentChart.Calender.Day;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.passion.R;
import com.example.passion.src.MainFragment.FragmentChart.Calender.Day.interfaces.FragmentCalenderDayActivityView;
import com.example.passion.src.MainFragment.FragmentChart.Calender.Day.models.TimeInfo;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.VerticalBarChart;
import org.eazegraph.lib.models.BarModel;

import java.util.ArrayList;

public class FragmentCalenderDay extends Fragment implements FragmentCalenderDayActivityView {

    private BarChart barChart;
    private VerticalBarChart verticalBarChart;
    private HorizontalBarChart horizontalBarChart;
    private PieChart pieChart;
    private int[] pieChartColorArray = new int[]{0xFF123456, 0xFF343456, 0xFF563456,0xFF873F56,0xFF563456};
    private int[] horiChartColorArray = new int[]{0xFF123456, 0xFF343456, 0xFF563456, 0xFF873F56, 0xFF563456};
    private FragmentCalenderDayService fragmentCalenderDayService;
    private TextView mTotal, mMax, mStart, mFinish;

    private void getDailyTime() {
        fragmentCalenderDayService.getDailyTime(2020,07,10); //입력한 과목 이름을 넣어준다
    }

    @Override
    public void fragmentCalenderDaySuccess(TimeInfo timeInfo) {
        timeInfo.getTotal();//총 공부시간 tv_calender_day_study_time
        timeInfo.getMax();//최대 집중 tv_calender_day_max_time
        timeInfo.getStart();//시작 시간 tv_calender_day_start_time
        timeInfo.getFinish();//종료 시간 tv_calender_day_end_time

        mTotal.setText(timeInfo.getTotal());
        mMax.setText(timeInfo.getMax());
        mStart.setText(timeInfo.getStart());
        mFinish.setText(timeInfo.getFinish());
    }

    @Override
    public void fragmentCalenderDayFailure(String message) {
        Toast.makeText(getContext(), "네트워크 통신의 오류입니다. 잠시만 기다려주세요", Toast.LENGTH_SHORT).show();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_calender_day, container, false);

        mTotal = viewGroup.findViewById(R.id.tv_calender_day_study_time);
        mMax = viewGroup.findViewById(R.id.tv_calender_day_max_time);
        mStart = viewGroup.findViewById(R.id.tv_calender_day_start_time);
        mFinish = viewGroup.findViewById(R.id.tv_calender_day_end_time);

        //barChart
//        barChart = (BarChart)viewGroup.findViewById(R.id.bar_chart_fragment_calender_day);
//
//        barChart.clearChart();
//
//        barChart.addBar(new BarModel(1, 0xFF123456));
//        barChart.addBar(new BarModel(2, 0xFF343456));
//        barChart.addBar(new BarModel(5, 0xFF563456));
//        barChart.addBar(new BarModel(10, 0xFF873F56));
//
//        barChart.startAnimation();

        //앱이터진다
//        getDailyTime();

        //verticarBarChart
        verticalBarChart = viewGroup.findViewById(R.id.vertical_bar_chart_calender_day);
        //차트정리
        verticalBarChart.clearChart();
        //데이터 추가
//        verticalBarChart.addBar(new BarModel("개발", 1, 0xFF123456));
        verticalBarChart.addBar(new BarModel("영어", 2, 0xFF343456));
        verticalBarChart.addBar(new BarModel("국어", 5, 0xFF563456));
        verticalBarChart.addBar(new BarModel("수학", 10, 0xFF873F56));
        verticalBarChart.addBar(new BarModel("토익", 7, 0xFF873F64));
        verticalBarChart.setShowValues(false);
        //애니메이션 시작
        verticalBarChart.startAnimation();

        //MPChart - PieChart
        pieChart = viewGroup.findViewById(R.id.pie_chart_fragment_calender_day);
        //파이 데이터 세팅
        PieDataSet pieDataSet = new PieDataSet(pieData(), "과목 시간측정");
        //파이 색상 세팅
        pieDataSet.setColors(pieChartColorArray);
        //파이 데이터 연결
        PieData pieData = new PieData(pieDataSet);
        //파이 속성
//        pieChart.setDrawEntryLabels(true);//글자(lavel) 보이기
        pieChart.setUsePercentValues(true);//퍼센트(value) 존재(글자 작음. 별도 설정필요)
        pieData.setValueTextSize(20);
//        pieChart.setCenterText("과목 퍼센트");//원형 안에 글자
//        pieChart.setCenterTextSize(30);//원형 글자 크기
//        pieChart.setCenterTextRadiusPercent(50);//원형 안 글자 : 긴 문장을 두문장으로 나누기
        pieChart.setHoleRadius(30);//가운데 원형 크기
        pieChart.setTransparentCircleRadius(20);//가운데 투명도 선크기
//        pieChart.setTransparentCircleColor(Color.RED);//가운데 투명도 선색상
        pieChart.setTransparentCircleAlpha(30);//가운데 투염도의 투명도
//        pieChart.setMaxAngle(180);//빈 앵글의 크기 서정
        pieChart.setData(pieData);
        pieChart.invalidate();



        //라벨 세팅
//        ArrayList<String> labels = new ArrayList<>();
//        labels.add("January");
//        labels.add("February");
//        labels.add("March");
//        labels.add("April");
//        labels.add("May");
//        //Horizontal Chart
//        horizontalBarChart = (HorizontalBarChart) viewGroup.findViewById(R.id.horizontal_bar_chart_fragment_calender_day);
//        //데이터 세팅
//        BarDataSet horizontalDataSet = new BarDataSet(getDataSetHori(), "Horizontal");
//        //데이터 색상 세팅
//        horizontalDataSet.setColors(horiChartColorArray);
//        //세팅된 데이터연결
//        BarData barData = new BarData(horizontalDataSet);
//
//        //차트 속성
//        horizontalBarChart.getXAxis().setDrawGridLines(false);
//        horizontalBarChart.setDrawBarShadow(false);
//        horizontalBarChart.setDrawValueAboveBar(true);
//        horizontalBarChart.getDescription().setEnabled(false);
//        horizontalBarChart.setPinchZoom(false);
//        horizontalBarChart.setDrawGridBackground(false);
//        horizontalBarChart.animateXY(500, 500);
//
//        //차트 데이터연결
//        horizontalBarChart.setData(barData);
//        //차트 시작
//        horizontalBarChart.invalidate();


        return viewGroup;
    }

    private ArrayList<BarEntry> getDataSetHori() {
        ArrayList<BarEntry> barEntryArrayList = new ArrayList<>();

        barEntryArrayList.add(new BarEntry(100, 1));
        barEntryArrayList.add(new BarEntry(200, 2));
        barEntryArrayList.add(new BarEntry(300, 3));
        barEntryArrayList.add(new BarEntry(400, 4));
        barEntryArrayList.add(new BarEntry(500, 5));


        return barEntryArrayList;
    }

    private ArrayList<PieEntry> pieData() {
        //데이터 넣어주기
        ArrayList<PieEntry> dataValue = new ArrayList<>();
        //파이차트 데이터 입력
        dataValue.add(new PieEntry(2, "영어"));
        dataValue.add(new PieEntry(5, "국어"));
        dataValue.add(new PieEntry(10, "수학"));
        dataValue.add(new PieEntry(7, "토익"));

        //리턴값 : 파이 데이터
        return dataValue;
    }



}
