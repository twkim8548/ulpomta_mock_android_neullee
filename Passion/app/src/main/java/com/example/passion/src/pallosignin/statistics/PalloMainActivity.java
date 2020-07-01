package com.example.passion.src.pallosignin.statistics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;
import com.example.passion.src.pallosignin.PalloSignInActivity;

import org.jetbrains.annotations.NotNull;

public class PalloMainActivity extends AppCompatActivity implements View.OnClickListener {

    //테스트
    private Button btnTest;
    private TextView tvTest;

    //멤버변수
    private Button btnLogin, btnNewStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pallo);
        //테스트 초기화
        btnTest = findViewById(R.id.test);
        tvTest = findViewById(R.id.tv_palloMain_test);

        //초기화
        btnNewStart = findViewById(R.id.btn_palloMain_NewStart);
        btnLogin = findViewById(R.id.btn_palloMain_LogIn);

        //버튼 설정
        btnNewStart.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(@NotNull View v) {
        switch (v.getId()) {
            case R.id.btn_palloMain_NewStart:

                break;
            case R.id.btn_palloMain_LogIn:
                Intent intent = new Intent(PalloMainActivity.this, PalloSignInActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
