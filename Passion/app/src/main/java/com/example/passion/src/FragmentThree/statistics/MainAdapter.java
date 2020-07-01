package com.example.passion.src.FragmentThree.statistics;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.passion.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private ArrayList<MainData> dataArrayList;

    public MainAdapter(ArrayList<MainData> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    //리스트뷰가 추가될때 실행
    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.CustomViewHolder holder, int position) {
        holder.ivPlay.setImageResource(dataArrayList.get(position).getIvPlay());
        holder.tvGoal.setText(dataArrayList.get(position).getTvGoal());
        holder.tvTime.setText(dataArrayList.get(position).getTvTime());

        //리스뷰터 클릭 또는 롱클릭
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.tvGoal.getText().toString();
                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();
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


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivPlay = (ImageView) itemView.findViewById(R.id.ivPlay);
            this.tvGoal = (TextView) itemView.findViewById(R.id.tvGoal);
            this.tvTime = (TextView) itemView.findViewById(R.id.tvTime);

        }
    }
}
