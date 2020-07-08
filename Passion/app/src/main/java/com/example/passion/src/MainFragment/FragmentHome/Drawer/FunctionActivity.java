package com.example.passion.src.MainFragment.FragmentHome.Drawer;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;

public class FunctionActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //뒤로가기
            case R.id.iv_function_keyboard_left:
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
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
