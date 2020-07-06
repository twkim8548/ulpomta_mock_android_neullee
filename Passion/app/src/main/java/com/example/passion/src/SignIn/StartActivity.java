package com.example.passion.src.SignIn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;
import com.example.passion.src.SignIn.SingInStart.SignInStartActivity;
import com.example.passion.src.SignUp.SignUpStart.SignUpStartActivity;

import org.jetbrains.annotations.NotNull;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    //멤버변수
    private Button btnLogin, btnNewStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //초기화
        btnNewStart = findViewById(R.id.btn_pallomain_new_start);
        btnLogin = findViewById(R.id.btn_pallomain_login);

        //버튼 설정
        btnNewStart.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(@NotNull View v) {
        switch (v.getId()) {
            //<기능> 새로 시작하기 버튼
            case R.id.btn_pallomain_new_start:
                Intent intent1 = new Intent(StartActivity.this, SignUpStartActivity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            //<기능> 로그인 버튼
            case R.id.btn_pallomain_login:
                Intent intent2 = new Intent(StartActivity.this, SignInStartActivity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            default:
                break;
        }
    }
}
