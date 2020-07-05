package com.example.passion.src.MainFragment.FragmentHome.FragmentHomeDialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.passion.R;

public class FragmentHomeInfoDialog extends Dialog {
    private Context context;
//    private FragmentHomeInfoDialogClickListener dialogInterface;
    private TextView mTitle, mMessage, mPositive;

    public FragmentHomeInfoDialog(Context context) { //FragmentHomeInfoDialogClickListener dialogInterface
        super(context);
        this.context = context;
//        this.dialogInterface = dialogInterface;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home_info_dialog);
        //초기화
        mTitle = findViewById(R.id.tv_fragment_home_dialog_title);//제목
        mMessage = findViewById(R.id.tv_fragment_home_dialog_message);//내용
        mPositive = findViewById(R.id.tv_fragment_home_dialog_positive);//확인

        //확인 버튼 클릭
        mPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }


}
