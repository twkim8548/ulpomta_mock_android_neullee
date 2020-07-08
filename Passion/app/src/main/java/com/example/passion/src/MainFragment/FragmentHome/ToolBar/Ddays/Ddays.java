package com.example.passion.src.MainFragment.FragmentHome.ToolBar.Ddays;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.passion.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Ddays extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvBack;
    private FloatingActionButton mFloatingActionButton;
    private ArrayList<DdaysData> mArrayList;
    private DdayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddays);

        //뒤로가기 버튼
        mIvBack = findViewById(R.id.iv_d_days_keyboard_left);
        mIvBack.setOnClickListener(this);

        //플로팅 버튼
        mFloatingActionButton = findViewById(R.id.flat_btn_d_days);
        mFloatingActionButton.setOnClickListener(this);

        //리사이클러뷰 세팅
        RecyclerView recyclerView = findViewById(R.id.rv_d_days);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mArrayList = new ArrayList<>();
        mAdapter = new DdayAdapter(mArrayList);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //추가된 데이터 가져오기
        SharedPreferences spf = getSharedPreferences("spfArray", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = spf.getString("ArrayList", null);
        Type type = new TypeToken<ArrayList<DdaysData>>() {
        }.getType();
        ArrayList<DdaysData> data = gson.fromJson(json, type);

        //값이 있을때 데이터 추가, 없을때는 모두 clear를 진행한다
        if (json != null) {
            //왜 안나오지? => 이상하다..ㅠㅜ
            //이게 맞는건지..?
            for (int i = 0; i < data.size(); i++) {
                mArrayList.add(data.get(i));
            }
            mAdapter.notifyDataSetChanged();
        } else {
            mArrayList.clear();
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //뒤로가기 버튼
            case R.id.iv_d_days_keyboard_left:
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            //플로팅 버튼
            case R.id.flat_btn_d_days:
                Intent intent = new Intent(this, AddDate.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
    }
}
