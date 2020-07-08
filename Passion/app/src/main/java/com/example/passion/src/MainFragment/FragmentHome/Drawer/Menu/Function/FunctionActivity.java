package com.example.passion.src.MainFragment.FragmentHome.Drawer.Menu.Function;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;
import com.example.passion.src.MainFragment.FragmentHome.Drawer.Menu.Function.Nickname.NickNameActivity;

public class FunctionActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        //뒤로가기
        ImageView ivBack = findViewById(R.id.iv_function_keyboard_left);
        ivBack.setOnClickListener(this);

        //닉네임
        LinearLayout linearLayout = findViewById(R.id.layout_function_nickname);
        linearLayout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //뒤로가기
            case R.id.iv_function_keyboard_left:
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
                break;

            case R.id.layout_function_nickname:
                Intent intent = new Intent(this, NickNameActivity.class);
                startActivity(intent);
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
