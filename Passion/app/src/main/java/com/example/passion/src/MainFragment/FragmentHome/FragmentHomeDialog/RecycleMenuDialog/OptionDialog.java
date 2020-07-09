package com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.RecycleMenuDialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.passion.R;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.OptionDialogInDialog;
import com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog.interfaces.CustomDialogClickListener;

public class OptionDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private CustomDialogClickListener customDialogClickListener;
    private TextView tvTitle, tvList1, tvList2, tvList3, tvList4, tvList5, tvNegative;
    private String mSubject;

//    public interface OnClickLinstener(){
//
//    }

    public OptionDialog(@NonNull Context context, CustomDialogClickListener customDialogClickListener,String mSubject) {
        super(context);
        this.context = context;
        this.customDialogClickListener = customDialogClickListener;
        this.mSubject = mSubject;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_dialog);

        tvTitle = findViewById(R.id.tv_dialog_title);//제목
        tvList1 = findViewById(R.id.tv_dialog_1);//To Do 만들기
        tvList2 = findViewById(R.id.tv_dialog_2);//To-Do 수정
        tvList3 = findViewById(R.id.tv_dialog_3);//과목 이름/색상 변경
        tvList4 = findViewById(R.id.tv_dialog_4);//과목 순서 변경
        tvList5 = findViewById(R.id.tv_dialog_5);//과목 삭제
        tvNegative = findViewById(R.id.tv_dialog_cancel);//취소

        tvList1.setOnClickListener(this);//To Do 만들기
        tvList2.setOnClickListener(this);//To-Do 수정
        tvList3.setOnClickListener(this);//과목 이름/색상 변경
        tvList4.setOnClickListener(this);//과목 순서 변경
        tvList5.setOnClickListener(this);//과목 삭제
        tvNegative.setOnClickListener(this);//취소


    }//onCreate


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            //To Do 만들기
            case R.id.tv_dialog_1:
                OptionDialogInDialog dialogInDialog = new OptionDialogInDialog(getContext(), new CustomDialogClickListener() {
                    @Override
                    public void onPositiveClick() {

                    }

                    @Override
                    public void onNegativeClick() {

                    }
                });
                dialogInDialog.setCanceledOnTouchOutside(true);
                dialogInDialog.setCancelable(true);
                dialogInDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                dialogInDialog.show();
                dismiss();
                break;

            //과목 삭제
            case R.id.tv_dialog_5:

                break;

            //취소
            case R.id.tv_dialog_cancel:
                customDialogClickListener.onNegativeClick();
                dismiss();
                break;


        }

    }
}//OptionDialog


