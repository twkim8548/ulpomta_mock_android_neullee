package com.example.passion.src.TimerFragment.FragmentHome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.passion.R;
import com.example.passion.src.TimerFragment.AddSubject.AddSubjectActivity;
import com.example.passion.src.TimerFragment.Dialog.FragmentHomeInfoDialog;
import com.example.passion.src.TimerFragment.FragmentHome.statistics.MainAdapter;
import com.example.passion.src.TimerFragment.FragmentHome.statistics.MainData;
import com.example.passion.src.TimerFragment.AddSubject

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FragmentHome extends Fragment implements View.OnClickListener {

    private ArrayList<MainData> mArrayList;
    private MainAdapter mMainAdapter;
    private String mSubject;

    //[구현대상]
    //<타이머 리셋>
    //1. 새벽 5시가 되는 경우 전체 타이머 시간이 리셋됩니다.

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //<설명> Fragment 화면 구성을 위한 세팅
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);//<설명> setContentView와 같은 역할

        //RecyclerView 세팅
        RecyclerView recyclerView = viewGroup.findViewById(R.id.recylerView_main);//리사이클러뷰
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());//리니어레이아웃메니저
        recyclerView.setLayoutManager(linearLayoutManager);//리사이클러뷰 리니어레이아웃 세팅
        mArrayList = new ArrayList<>();//어레이리스트 데이터
        mMainAdapter = new MainAdapter(mArrayList);//어뎁터
        recyclerView.setAdapter(mMainAdapter);//리사이클러뷰 어뎁터 세팅

        //과목 추가하기 세팅
        TextView tvAddSubject = viewGroup.findViewById(R.id.tv_FragThree_addSubject);//과목추가
        tvAddSubject.setOnClickListener(this);//클릭 메소드 > <Fragment 적용불가>

        //오늘날짜 세팅
        TextView toDay = viewGroup.findViewById(R.id.tv_fragment_home_today);//오늘날짜
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy" + "." + "M" + "." + "d"); //'오늘날짜' 구성
        toDay.setText(simpleDateFormat.format(new Date()));

        //정보 세팅
        ImageView info = viewGroup.findViewById(R.id.iv_fragment_home_info);
        info.setOnClickListener(this);


        return viewGroup;//화면
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //<기능> 과목 추가하기
            //<설명> 과목 추가 > 과목 이름 추가하는 엑티비티
            case R.id.tv_FragThree_addSubject:
                Toast.makeText(v.getContext(), "개발중", Toast.LENGTH_SHORT).show();
                //<설명> 과목추가 화면으로 이동 (서버에 저장한다)
                Intent intent = new Intent(getContext(), AddSubjectActivity.class);
                startActivity(intent);
                mArrayList.add()


                break;


            //<기능> '?' 정보 안내
            case R.id.iv_fragment_home_info:
                //<미구현> 다이얼로그 사이즈 커스텀 필요함!!
                final FragmentHomeInfoDialog dialog = new FragmentHomeInfoDialog(getContext());
                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();



                break;
            default:
                break;
        }
    }
}
