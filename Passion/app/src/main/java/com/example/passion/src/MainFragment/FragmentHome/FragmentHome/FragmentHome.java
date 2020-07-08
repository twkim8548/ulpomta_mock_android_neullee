package com.example.passion.src.MainFragment.FragmentHome.FragmentHome;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
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
import com.example.passion.src.MainFragment.FragmentHome.ToolBar.Ddays.Ddays;
import com.example.passion.src.MainFragment.FragmentHome.ToolBar.PhoneLock.PhoneLock;
import com.example.passion.src.MainFragment.FragmentHome.Drawer.StatusMessage;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.FragmentHomeInfoDialog;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHome.statistics.FragmentHomeAdapter;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHome.statistics.FragmentHomeData;
import com.example.passion.src.MainFragment.FragmentHome.ToolBar.StudyPlanner.StudyPlanner;
import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FragmentHome extends Fragment implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<FragmentHomeData> mArrayList;
    private FragmentHomeAdapter mFragmentHomeAdapter;
    private ImageButton ivBtnAddSubject;
    private DrawerLayout mDrawerLayout;

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
        mFragmentHomeAdapter = new FragmentHomeAdapter(mArrayList);//어뎁터
        recyclerView.setAdapter(mFragmentHomeAdapter);//리사이클러뷰 어뎁터 세팅


        //네비게이션 드로어
        mDrawerLayout = viewGroup.findViewById(R.id.drawer_layout);//drawer_layout
        @SuppressLint("CutPasteId") ImageView mIvMenu = viewGroup.findViewById(R.id.iv_main_menu);
        mIvMenu.setOnClickListener(this);

        //상태메세지 클릭
        //반영 불가
        //question 질문 올림
//        TextView mTvHeader = viewGroup.findViewById(R.id.tv_drawer_status_message);//drawer_layout
//        mTvHeader.setOnClickListener(this);

        //네비게이션뷰 세팅
        NavigationView mNavigationView = viewGroup.findViewById(R.id.drawer_navigation_view);
        mNavigationView.setNavigationItemSelectedListener(this);


        //과목 추가하기 세팅
        ivBtnAddSubject = viewGroup.findViewById(R.id.btn_FragThree_addSubject);
        ivBtnAddSubject.setOnClickListener(this);//클릭 메소드 > <Fragment 적용불가>

        //폰잠금
        ImageView mIvPhonLock = viewGroup.findViewById(R.id.iv_main_lock);
        mIvPhonLock.setOnClickListener(this);

        //D-days를 입력해주세요
        TextView mTvDdays = viewGroup.findViewById(R.id.tv_main_d_day);
        mTvDdays.setOnClickListener(this);

        //study Planner
        ImageView mTvStudyPlanner = viewGroup.findViewById(R.id.iv_main_check);
        mTvStudyPlanner.setOnClickListener(this);

        //오늘날짜 세팅
        TextView toDay = viewGroup.findViewById(R.id.tv_fragment_home_today);//오늘날짜
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy" + ". " + "M" + ". " + "d"); //'오늘날짜' 구성
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
            case R.id.btn_FragThree_addSubject:
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.fade);
                ivBtnAddSubject.startAnimation(animation);
                //<설명> 과목추가 화면으로 이동 (서버에 저장한다)
                Intent intent = new Intent(getContext(), AddSubjectActivity.class);
                startActivityForResult(intent, 1001);//<기능> Activity 를 넘기고 돌아올때까지 기다린다
                getActivity().overridePendingTransition(R.anim.fadein, R.anim.fadeout);
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
            //폰잠금
            case R.id.iv_main_lock:
                Intent intent1 = new Intent(getContext(), PhoneLock.class);
                startActivity(intent1);
                getActivity().overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            //D-days
            case R.id.tv_main_d_day:
                Intent intent2 = new Intent(getContext(), Ddays.class);
                startActivity(intent2);
                getActivity().overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            //StudyPlanner
            case R.id.iv_main_check:
                Intent intent3 = new Intent(getContext(), StudyPlanner.class);
                startActivity(intent3);
                getActivity().overridePendingTransition(R.anim.fadein, R.anim.fadeout);
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
        String mSubjectName = spf.getString("subjectName", null);

        if (mSubjectName != null) {
            FragmentHomeData fragmentHomeData = new FragmentHomeData(R.drawable.ic_play, mSubjectName, "00:00:00", R.drawable.ic_more);//시간 변경하기
            mArrayList.add(fragmentHomeData);
            mFragmentHomeAdapter.notifyDataSetChanged();
        }
        //<설명> 리스트뷰에
        //<구현대상> 시간이 남으면 ivPlay의 tint 색 변경하기

    }


    //네비게이션 메뉴 클릭
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//        <완료>nav_notice
//        nav_offline
//        nav_function
//        nav_days
//        nav_help
//        nav_inquiry
//        nav_friendAdd
//        nav_review
//        nav_log_out

        switch (item.getItemId()) {
            case R.id.nav_notice:
                Intent intent = new Intent(getContext(), StatusMessage.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            case R.id.nav_offline:
                String title = "오프라인모드";
                String message = "\n\n오프라인 모드는 인터넷 사용없이 측정하는 모드입니다.\n\n" +
                        "오프라인에서 측정된 시간은 온라인 모드로 돌아올때 한번에 합쳐집니다.\n\n" +
                        "오프라인 모드로 변경하시겠습니까?\n\n";
                String cancel = "취소", check = "확인";
                alertDialog(title,message,cancel,check);
                break;
        }
        return false;
    }

    public void alertDialog(String title, String message, String cancel, String check) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(title).setMessage(message);
        builder.setNegativeButton(cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton(check, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}
