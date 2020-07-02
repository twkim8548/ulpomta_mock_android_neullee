package com.example.passion.src.SignIn.PalloMain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;
import com.example.passion.src.SignIn.PalloSingIn.PalloSignInActivity;

import org.jetbrains.annotations.NotNull;

public class PalloMainActivity extends AppCompatActivity implements View.OnClickListener {
    //멤버변수
    private Button btnLogin, btnNewStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pallo);
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
            case R.id.btn_pallomain_new_start:

                break;
            case R.id.btn_pallomain_login:
                Intent intent = new Intent(PalloMainActivity.this, PalloSignInActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            default:
                break;
        }
    }
}
