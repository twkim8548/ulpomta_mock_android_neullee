package com.example.passion.src.MainFragment.FragmentHome;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.passion.R;
import com.example.passion.src.MainFragment.FragmentHome.AddSubject.AddSubjectActivity;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.FragmentHomeInfoDialog;
import com.example.passion.src.MainFragment.FragmentHome.statistics.FragmentHomeAdapter;
import com.example.passion.src.MainFragment.FragmentHome.statistics.FragmentHomeData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FragmentHome extends Fragment implements View.OnClickListener {

    private ArrayList<FragmentHomeData> mArrayList;
    private FragmentHomeAdapter mFragmentHomeAdapter;
    private String mSubjectName;

    private DrawerLayout mDrawerLayout;
//    private ImageView mIvMenu;

    //[구현대상]
    //<타이머 리셋>
    //1. 새벽 5시가 되는 경우 전체 타이머 시간이 리셋됩니다.

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //<설명> Fragment 화면 구성을 위한 세팅
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);//<설명> setContentView와 같은 역할
        //can_not_fragment_home

        //RecyclerView 세팅
        RecyclerView recyclerView = viewGroup.findViewById(R.id.recylerView_main);//리사이클러뷰
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());//리니어레이아웃메니저
        recyclerView.setLayoutManager(linearLayoutManager);//리사이클러뷰 리니어레이아웃 세팅
        mArrayList = new ArrayList<>();//어레이리스트 데이터
        mFragmentHomeAdapter = new FragmentHomeAdapter(mArrayList);//어뎁터
        recyclerView.setAdapter(mFragmentHomeAdapter);//리사이클러뷰 어뎁터 세팅


        //네비게이션 드로어
        mDrawerLayout = viewGroup.findViewById(R.id.drawer_layout);//drawer_layout
        ImageView mIvMenu = viewGroup.findViewById(R.id.iv_main_menu);
        mIvMenu.setOnClickListener(this);


        //과목 추가하기 세팅
        TextView tvAddSubject = viewGroup.findViewById(R.id.tv_FragThree_addSubject);//과목추가
        tvAddSubject.setOnClickListener(this);//클릭 메소드 > <Fragment 적용불가>

        //오늘날짜 세팅
        TextView toDay = viewGroup.findViewById(R.id.tv_fragment_home_today);//오늘날짜
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy" + "." + "M" + "." + "d"); //'오늘날짜' 구성
        toDay.setText(simpleDateFormat.format(new Date()));

        //정보 세팅
        ImageView info = viewGroup.findViewById(R.id.iv_fragment_home_info);
        info.setOnClickListener(this);

        //메뉴를 클릭하면 drawabl 메뉴 확인
        ImageView drawableMenu = viewGroup.findViewById(R.id.iv_main_menu);
        drawableMenu.setOnClickListener(this);


        return viewGroup;//화면
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //<기능> 과목 추가하기
            //<설명> 과목 추가 > 과목 이름 추가하는 엑티비티
            case R.id.tv_FragThree_addSubject:
                //<설명> 과목추가 화면으로 이동 (서버에 저장한다)
                Intent intent = new Intent(getContext(), AddSubjectActivity.class);
                startActivityForResult(intent, 1001);//<기능> Activity 를 넘기고 돌아올때까지 기다린다
                break;
            //<기능> '?' 정보 안내
            case R.id.iv_fragment_home_info:
                //<미구현> 다이얼로그 사이즈 커스텀 필요함!!
                final FragmentHomeInfoDialog dialog = new FragmentHomeInfoDialog(getContext());
                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
                break;
            // 메뉴를 클릭하면 왼쪽에서 레이아웃 확인
            case R.id.iv_main_menu:
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //<설명>AddSubjectActivity 에서 저장된 과목 불러온다.
        SharedPreferences spf = getContext().getSharedPreferences("spf", Context.MODE_PRIVATE);
        mSubjectName = spf.getString("subjectName", null);

        if (mSubjectName!=null){
            FragmentHomeData fragmentHomeData = new FragmentHomeData(R.drawable.ic_play, mSubjectName, "00:00:00", R.drawable.ic_more);//시간 변경하기
            mArrayList.add(fragmentHomeData);
            mFragmentHomeAdapter.notifyDataSetChanged();
        }
        //<설명> 리스트뷰에
        //<구현대상> 시간이 남으면 ivPlay의 tint 색 변경하기

    }




}
