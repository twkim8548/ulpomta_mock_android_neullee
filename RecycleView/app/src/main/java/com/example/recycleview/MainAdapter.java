package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CutomViewHolder> {

    //데이터를 담은 ArrayList
    private ArrayList<MainData> arrayList;

    //ArrayList 생성자
    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    //리사이클러뷰가 시작될때 가져오는 <시작 생명주기>
    @NonNull
    @Override
    public MainAdapter.CutomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //item 리스트 레이아웃 가져오기
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        //커스텀뷰홀더 생성
        CutomViewHolder holder = new CutomViewHolder(view);
        return holder;
    }

    //추가될때 생명주기
    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.CutomViewHolder holder, int position) {
        //view를 생성한 부분을 가져온다
        holder.ivPlay.setImageResource(arrayList.get(position).getIvPlay());
        holder.tvGoal.setText(arrayList.get(position).getTvGoal());
        holder.tvTime.setText(arrayList.get(position).getTvTime());
        holder.ivMenu.setImageResource(arrayList.get(position).getIvMenu());


        //리스뷰가 클릭이 되었을때 실행
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curGoal = holder.tvGoal.getText().toString();
                Toast.makeText(v.getContext(), curGoal, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                remove(holder.getAdapterPosition());
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position) {
        try {
            arrayList.remove(position);
            notifyItemRemoved(position);//새로고침
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    //리사이클뷰에서 보여지는 중요한 부분 (가장 먼저 item에 들어가는 리스트를 초기화 해준다)
    public class CutomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView ivPlay;
        protected TextView tvGoal;
        protected TextView tvTime;
        protected ImageView ivMenu;

        public CutomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivPlay = (ImageView) itemView.findViewById(R.id.iv_play);
            this.tvGoal = (TextView) itemView.findViewById(R.id.tv_Goal);
            this.tvTime = (TextView) itemView.findViewById(R.id.tv_Time);
            this.ivMenu = (ImageView) itemView.findViewById(R.id.iv_Menu);


        }
    }
}
