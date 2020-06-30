package com.example.passion.src.pallomain.statistics;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.passion.R;
import com.example.passion.src.BaseActivity;
import com.example.passion.src.Main.statistics.CustomDialogClickListener;
import com.example.passion.src.Main.statistics.OptionDialog;
import com.example.passion.src.pallomain.PalloMainService;
import com.example.passion.src.pallomain.interfaces.MainActivityView;

public class PalloMainActivity extends BaseActivity implements MainActivityView {

    Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pallo);
        test = findViewById(R.id.test);


        //커스텀 다이얼로그 테스트입니다.
        //걱정 : 다이얼록 테스트의 경우 WRAO CONTENT만 나와서 불편한 점이 있습니다.
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final OptionDialog optionDialog = new OptionDialog(PalloMainActivity.this, new CustomDialogClickListener() {
                    @Override
                    public void onPositiveClick() {

                    }

                    @Override
                    public void onNegativeClick() {

                    }
                });

                optionDialog.setCanceledOnTouchOutside(true);
                optionDialog.setCancelable(true);
                optionDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                optionDialog.show();

            }
        });

    }

    private void tryGetTest() {
        showProgressDialog();

        final PalloMainService palloMainService = new PalloMainService(this);
        palloMainService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn_hello_world:
                tryGetTest();
                break;
            default:
                break;
        }
    }
}
