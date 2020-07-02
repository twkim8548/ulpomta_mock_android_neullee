package com.example.passion.src.SignUp.SignUpStart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;
import com.example.passion.src.SignIn.SingInStart.SignInStartActivity;

public class SignUpStartActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_start);
        TextView signIn = findViewById(R.id.tv_sign_up_sign_in);//로그인
        signIn.setOnClickListener(this);//로그인
        ImageView ivBack = findViewById(R.id.iv_sign_up_keyboard_left);// '<'뒤로가기 버튼
        ivBack.setOnClickListener(this);// '<'뒤로가기 버튼
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //<기능> '<' 뒤로 돌아가기
            case R.id.iv_sign_up_keyboard_left:
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            //<기능> 로그인
            case R.id.tv_sign_up_sign_in:
                Intent intent = new Intent(this, SignInStartActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
    }
}
