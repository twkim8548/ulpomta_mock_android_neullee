package com.example.passion.src.FragmentThree;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.passion.R;
import com.example.passion.src.FragmentThree.statistics.MainAdapter;
import com.example.passion.src.FragmentThree.statistics.MainData;

import java.util.ArrayList;

public class ThreeFragment extends Fragment {

    ViewGroup viewGroup;

    private ArrayList<MainData> mArrayList;
    private MainAdapter mMainAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager linearLayoutManager;

    TextView mTvAddGoal;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_three_home, container, false);

        mRecyclerView = viewGroup.findViewById(R.id.recylerView_main);//리사이클러뷰
        linearLayoutManager = new LinearLayoutManager(getContext());//리니어레이아웃메니저
        mRecyclerView.setLayoutManager(linearLayoutManager);//리사이클러뷰 리니어레이아웃 세팅

        mArrayList = new ArrayList<>();//어레이리스트 데이터
        mMainAdapter = new MainAdapter(mArrayList);//어뎁터
        mRecyclerView.setAdapter(mMainAdapter);//리사이클러뷰 어뎁터 세팅

        mTvAddGoal = viewGroup.findViewById(R.id.tv_FragThree_addSubject);//과목추가
        mTvAddGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainData mainData = new MainData(R.drawable.ic_play,"목표/과목(입력값","00:00:00(시간)",R.drawable.ic_more);
                mArrayList.add(mainData);
                mMainAdapter.notifyDataSetChanged();
            }
        });


        return viewGroup;
    }
}
