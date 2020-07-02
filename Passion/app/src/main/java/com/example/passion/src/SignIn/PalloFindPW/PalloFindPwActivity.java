package com.example.passion.src.SignIn.PalloFindPW;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;

public class PalloFindPwActivity extends AppCompatActivity {

    //멤버변수
    Button mBtnFindPW; //패스워드를 찾는 버튼
    EditText mEtEmail; //이메일 입력

    //유효성 검사


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallo_find_pw);
        mBtnFindPW = findViewById(R.id.btn_palloFindPW_Login);
        mEtEmail = findViewById(R.id.et_palloFindPW_enterEmail);


        //<배경> 해당 화면에는 버튼 하나만 클릭을 하기 때문에 setOnclickListener과 new를 배정
        //<기능> '이메일 계정확인' 버튼을 누르면 알럿창이 확인됩니다.
        mBtnFindPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //<기능> 입력한 email 저장
                String email = mEtEmail.getText().toString();
                //<기능> 네트워크 통신신
           }
        });

    }

}
