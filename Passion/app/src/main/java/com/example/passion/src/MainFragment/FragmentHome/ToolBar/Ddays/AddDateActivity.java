package com.example.passion.src.MainFragment.FragmentHome.ToolBar.Ddays;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddDateActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTvCalender;
    int mCurYear, mCurMonth, mCurDate;//현재 날짜
    int mChooseYear, mChooseMonth, mChooseDate;//선택한 날짜
    long mResultToday, mResultChooseDay;
    String mDday;
    DatePickerDialog mDatePickerDialog;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_date);
        //뒤로가기 버튼
        ImageView ivBack = findViewById(R.id.iv_d_days_add_keyboard_left);
        ivBack.setOnClickListener(this);
        Button btnAdd = findViewById(R.id.btn_d_days_add_commit);
        btnAdd.setOnClickListener(this);
        //오늘날짜 세팅
        //날짜 클릭 > 달력
        mTvCalender = findViewById(R.id.date_d_days_add_calender);
        mTvCalender.setOnClickListener(this);

        Date calDate = Calendar.getInstance().getTime();
        String curDate = new SimpleDateFormat("yyy년  M월  d일", Locale.getDefault()).format(calDate);
        mTvCalender.setText(curDate);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //뒤로가기
            case R.id.iv_d_days_add_keyboard_left:
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            //추가하기
            case R.id.btn_d_days_add_commit:
                //추가하기 > 입력한 D-day명과 날짜가 SharedPreference로 넘어간다
                Toast.makeText(this, "추가하기를 누르면 SPF!", Toast.LENGTH_SHORT).show();
                String titles = mTvCalender.getText().toString();//타이틀(입력한 내용)
                String date = mChooseYear + ". " + mChooseMonth + ". " + mChooseDate;//선택한 날짜
                //D-day 계산
                int resultDday = (int) ((mResultChooseDay - mResultToday) / (24 * 60 * 60 * 1000)) - 1;
                if (resultDday > 0) {
                    mDday = "D-" + resultDday;
                } else {
                    mDday = "D+" + resultDday;
                }

                if (titles.length() < 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("d-day 추가하기").setMessage("d-day 이름을 입력해주세요.");
                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                } else {
                    //DdaysData 추가
                    DdaysData data = new DdaysData(titles, date, mDday, R.drawable.ic_more);
                    //                    //SharedPreferences에 DdaysData 담아서 보내기
                    SharedPreferences spf = getSharedPreferences("spfArray", MODE_PRIVATE);
                    SharedPreferences.Editor editor = spf.edit();
                    //Gson을 이용한 String 변경 및 저장
                    Gson gson = new GsonBuilder().create();
                    String json = gson.toJson(data); // data(obj -> json) 파싱
                    editor.putString("ArrayList", json);
                    editor.apply();
                    //엑티비티 종료시 유효성 검사
                    if (json != null) {
                        finish();
                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    }
                    Toast.makeText(this, "네트워크 오류로 저장이 불가능합니다.", Toast.LENGTH_SHORT).show();
                }
                break;
            //날짜 클릭 > 달력(DatePicker)
            case R.id.date_d_days_add_calender:
                //오늘 날짜 구하기
                Calendar cal = Calendar.getInstance();
                mCurYear = cal.get(Calendar.YEAR);
                mCurMonth = cal.get(Calendar.MONTH);
                mCurDate = cal.get(Calendar.DATE);
                mResultToday = cal.getTimeInMillis();//D-day를 구하기 위한 '오늘날짜' 계산
                //달력
                mDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //선택한 날짜 세팅
                        mTvCalender.setText(year + "년 " + (month + 1) + "월 " + dayOfMonth + "일");
                        //선택한 날짜 받아오기
                        mChooseYear = year;
                        mChooseMonth = month;
                        mChooseDate = dayOfMonth;
                        //D-day를 구하기 위한 '선택한 날짜' 계산
                        Calendar chooseCalendar = Calendar.getInstance();
                        chooseCalendar.set(mChooseYear, mChooseMonth, mChooseDate);
                        mResultChooseDay = chooseCalendar.getTimeInMillis();
                    }
                }, 2020, 7, 8);
                mDatePickerDialog = new DatePickerDialog(this, R.style.DialogTheme);
                mDatePickerDialog.setTitle("SELECT DATE");
                mDatePickerDialog.setCancelable(true);
                mDatePickerDialog.setCanceledOnTouchOutside(true);
                mDatePickerDialog.show();

                mDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mTvCalender.setText(year + "년 " + (month + 1) + "월 " + dayOfMonth + "일");

                    }
                },2020,7,9);
                mDatePickerDialog = new DatePickerDialog(this, R.style.DialogTheme);
                mDatePickerDialog.setTitle("SELECT DATE");
                mDatePickerDialog.setCancelable(true);
                mDatePickerDialog.setCanceledOnTouchOutside(true);
                mDatePickerDialog.show();



                break;


        }
    }
}
