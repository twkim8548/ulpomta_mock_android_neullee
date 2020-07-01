package com.example.passion.src.PalloMain.statistics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;
import com.example.passion.src.PalloSingIn.PalloSignInActivity;

import org.jetbrains.annotations.NotNull;

public class PalloMainActivity extends AppCompatActivity implements View.OnClickListener {
    //멤버변수
    private Button btnLogin, btnNewStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pallo);
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
