package com.example.passion.src.Main.statistics;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.passion.R;

public class OptionDialog extends Dialog {

    private Context context;
    private CustomDialogClickListener customDialogClickListener;
    private TextView tvTitle, tvList1, tvList2, tvList3, tvList4, tvList5, tvNegative;

    public OptionDialog(@NonNull Context context, CustomDialogClickListener customDialogClickListener) {
        super(context);
        this.context = context;
        this.customDialogClickListener = customDialogClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_dialog);
        tvTitle = findViewById(R.id.tv_dialog_title);
        tvList1 = findViewById(R.id.tv_dialog_1);
        tvList2 = findViewById(R.id.tv_dialog_2);
        tvList3 = findViewById(R.id.tv_dialog_3);
        tvList4 = findViewById(R.id.tv_dialog_4);
        tvList5 = findViewById(R.id.tv_dialog_5);
        tvNegative = findViewById(R.id.tv_dialog_cancel);

        tvList1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });


        tvNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialogClickListener.onNegativeClick();
                dismiss();
            }
        });


    }//onCreate


}//OptionDialog


