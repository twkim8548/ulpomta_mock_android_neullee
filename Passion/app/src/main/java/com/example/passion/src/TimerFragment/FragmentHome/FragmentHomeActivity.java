package com.example.passion.src.TimerFragment.FragmentHome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.passion.R;
import com.example.passion.src.TimerFragment.FragmentHome.statistics.AddSubjectActivity;
import com.example.passion.src.TimerFragment.FragmentHome.statistics.MainAdapter;
import com.example.passion.src.TimerFragment.FragmentHome.statistics.MainData;

import java.util.ArrayList;

public class FragmentHomeActivity extends Fragment implements View.OnClickListener {

    ViewGroup viewGroup;

    private ArrayList<MainData> mArrayList;
    private MainAdapter mMainAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager linearLayoutManager;

    private TextView mTvAddGoal;
    private String mSubject;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = viewGroup.findViewById(R.id.recylerView_main);//리사이클러뷰
        linearLayoutManager = new LinearLayoutManager(getContext());//리니어레이아웃메니저
        mRecyclerView.setLayoutManager(linearLayoutManager);//리사이클러뷰 리니어레이아웃 세팅

        mArrayList = new ArrayList<>();//어레이리스트 데이터
        mMainAdapter = new MainAdapter(mArrayList);//어뎁터
        mRecyclerView.setAdapter(mMainAdapter);//리사이클러뷰 어뎁터 세팅
        mTvAddGoal = viewGroup.findViewById(R.id.tv_FragThree_addSubject);//과목추가
        mTvAddGoal.setOnClickListener(this);//클릭 메소드 > <Fragment 적용불가>

        return viewGroup;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_FragThree_addSubject:
                Toast.makeText(v.getContext(), "개발중", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), AddSubjectActivity.class);
                startActivity(intent);
//                if (mSubject != null) {
//                    Intent intent1 = new Intent();
//                    mSubject = intent1.getStringExtra("AddSubject");
//                    <아래 목표/과목을 받아오는 구현하기>
                MainData mainData = new MainData(R.drawable.ic_play, "목표/과목", "00:00:00", R.drawable.ic_more);
                mArrayList.add(mainData);
                mMainAdapter.notifyDataSetChanged();
//                }
                break;
            default:
                break;
        }
    }
}
