package com.example.passion.src.MainFragment.FragmentHome.ToolBar.Ddays;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;

public class Ddays extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddays);

        //뒤로가기 버튼
        mIvBack = findViewById(R.id.iv_d_days_keyboard_left);
        mIvBack.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //뒤로가기 버튼
            case R.id.iv_d_days_keyboard_left:
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
    }
}
