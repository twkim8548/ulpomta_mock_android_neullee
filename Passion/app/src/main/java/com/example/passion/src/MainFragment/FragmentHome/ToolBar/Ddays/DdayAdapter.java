package com.example.passion.src.MainFragment.FragmentHome.ToolBar.Ddays;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

//1. RecyclerView.Adapter<> extends
//2. import => CustomViewHolder(이너클래스) => 빨간줄 A+enter

public class DdayAdapter extends RecyclerView.Adapter<DdayAdapter.CustomViewHolder> {

    private ArrayList<DdaysData> arrayList;

    public DdayAdapter(ArrayList<DdaysData> arrayList) {
        this.arrayList = arrayList;
    }


    //onCreateViewHolder : 리스트뷰가 처음 생성될때의 생명주기
    @NonNull
    @Override
    public DdayAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.d_days_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    //실제, 추가될때의 생명주기
    @Override
    public void onBindViewHolder(@NonNull final DdayAdapter.CustomViewHolder holder, final int position) {
        //리스트뷰 선택될때 값 세팅
        holder.mEnterContents.setText(arrayList.get(position).getmEnterContents());
        holder.mEnterDays.setText(arrayList.get(position).getmEnterDays());
        holder.mDate.setText(arrayList.get(position).getmDate());
        holder.mIvMenu.setImageResource(arrayList.get(position).getmIvMenu());


        //리스트뷰 선택되는 부분 처리
        holder.itemView.setTag(position);//리스트뷰의 인덱스(position) 확인
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //클릭된 리스트뷰의 이름 (예제)
                String curName = holder.mEnterContents.getText().toString();
                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });

        holder.mIvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //현재 리스트뷰의 이름
                String curName = holder.mEnterContents.getText().toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("D-day 삭제").setMessage("'" + curName + "'" + "삭제하시겠습니까?");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arrayList.remove(position);
                        arrayList.notify();
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //이너클래스
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView mEnterContents;
        protected TextView mEnterDays;
        protected TextView mDate;
        protected ImageView mIvMenu;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mEnterContents = (TextView) itemView.findViewById(R.id.tv_d_days_enter_contents);
            this.mEnterDays = (TextView) itemView.findViewById(R.id.tv_d_days_enterDay);
            this.mDate = (TextView) itemView.findViewById(R.id.tv_d_days_d_days);
            this.mIvMenu = (ImageView) itemView.findViewById(R.id.iv_d_days_menu);


        }
    }


//    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.d_days_item, parent, false);
//            return (dataArrayList != null ? dataArrayList.size() : 0);


}

