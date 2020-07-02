package com.example.passion.src.Access.FragmentThree.statistics;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.passion.R;
import com.example.passion.src.Access.FragmentMain.interfaces.CustomDialogClickListener;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private ArrayList<MainData> dataArrayList;

    public MainAdapter(ArrayList<MainData> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    //리스트뷰가 추가될때 실행
    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.CustomViewHolder holder, int position) {
        holder.ivPlay.setImageResource(dataArrayList.get(position).getIvPlay());
        holder.tvGoal.setText(dataArrayList.get(position).getTvGoal());
        holder.tvTime.setText(dataArrayList.get(position).getTvTime());
        holder.ivMenu.setImageResource(dataArrayList.get(position).getIvMenu());

        //메뉴를 클릭했을 때 나오는 엑티비티화면
        holder.ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //클릭시 커스텀 다이얼로그 화면이 나옵니다.
                OptionDialog optionDialog = new OptionDialog(v.getContext(), new CustomDialogClickListener() {
                    @Override
                    public void onPositiveClick() {

                    }

                    @Override
                    public void onNegativeClick() {

                    }
                });
                optionDialog.setCancelable(true);
                optionDialog.setCanceledOnTouchOutside(true);
                optionDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                optionDialog.show();
            }
        });

        //리스뷰터가 클릭되었을 때 구현되어야 함
        //<미구현>
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //클릭시 카운트 화면으로 넘어간다
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataArrayList ? dataArrayList.size() : 0);
    }

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
}
