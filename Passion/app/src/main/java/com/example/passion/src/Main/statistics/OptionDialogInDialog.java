package com.example.passion.src.Main.statistics;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.passion.R;

public class OptionDialogInDialog extends Dialog {

    private Context context;
    private CustomDialogClickListener customDialogClickListener;

    private EditText etContents;
    private TextView tvCancel, tvCheck;

    public OptionDialogInDialog(@NonNull Context context, CustomDialogClickListener customDialogClickListener) {
        super(context);
        this.context = context;
        this.customDialogClickListener = customDialogClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_dialog_in_dialog);
        etContents = findViewById(R.id.et_dialogIn_EnterToDo);
        tvCancel = findViewById(R.id.tv_dialogIn_cancel);
        tvCheck = findViewById(R.id.tv_dialogIn_check);

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialogClickListener.onNegativeClick();
                dismiss();
            }
        });

        //입력한 EditText는 확인을 누를때 리스트뷰 하단에 내용이 보내져야합니다.
        //미구현
        tvCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
