package com.example.passion.src.MainFragment.FragmentHome.FragmentHome.statistics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.passion.R;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog.OptionDialog;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.interfaces.CustomDialogClickListener;
import com.example.passion.src.Timer.TimerMainActivity;

import java.util.ArrayList;

public class FragmentHomeAdapter extends RecyclerView.Adapter<FragmentHomeAdapter.CustomViewHolder> implements View.OnClickListener {

    private String mSubject;

    private ArrayList<FragmentHomeData> dataArrayList;

    public FragmentHomeAdapter(ArrayList<FragmentHomeData> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }

    @NonNull
    @Override
    public FragmentHomeAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    //리스트뷰 초기화
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView ivPlay;
        protected TextView tvGoal;
        protected TextView tvTime;
        protected ImageView ivMenu;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivPlay = (ImageView) itemView.findViewById(R.id.iv_item_main);
            this.tvGoal = (TextView) itemView.findViewById(R.id.tv_item_goal);
            this.tvTime = (TextView) itemView.findViewById(R.id.tv_item_main);
            this.ivMenu = (ImageView) itemView.findViewById(R.id.iv_item_menu);
        }
    }

    //리스트뷰가 추가될때 실행
    @Override
    public void onBindViewHolder(@NonNull final FragmentHomeAdapter.CustomViewHolder holder, final int position) {
        holder.ivPlay.setImageResource(dataArrayList.get(position).getIvPlay());
        holder.tvGoal.setText(dataArrayList.get(position).getTvSubject());
        holder.tvTime.setText(dataArrayList.get(position).getTvTime());
        holder.ivMenu.setImageResource(dataArrayList.get(position).getIvMenu());

        //리스트뷰 인덱스
        mSubject = dataArrayList.get(position).getTvSubject();

        //메뉴 클릭
        holder.ivMenu.setOnClickListener(this);

        //리스트뷰 클릭
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                SharedPreferences spf = v.getContext().getSharedPreferences("spf", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = spf.edit();
                editor.putInt("position", position);
                editor.commit();

                //클릭시 카운트 화면으로 넘어간다
                Intent intent = new Intent(v.getContext(), TimerMainActivity.class);
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataArrayList ? dataArrayList.size() : 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_item_menu:
                //클릭시 커스텀 다이얼로그 화면이 나옵니다.
                OptionDialog optionDialog = new OptionDialog(v.getContext(), new CustomDialogClickListener() {
                    @Override
                    public void onPositiveClick() {

                    }

                    @Override
                    public void onNegativeClick() {

                    }
                }, mSubject);//제목을 넘겨받는다
                optionDialog.setCancelable(true);
                optionDialog.setCanceledOnTouchOutside(true);
                optionDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                optionDialog.show();
                break;


        }
    }


}
