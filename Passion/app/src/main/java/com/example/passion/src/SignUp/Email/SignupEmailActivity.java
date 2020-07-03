package com.example.passion.src.SignUp.Email;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;

public class SignupEmailActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText mEnterEmail, mEnterPw, mEnterCheckPw;//입력 : 이메일,비밀번호, 비밀번호 확인
    private String mStrEmail, mStrPw, mStrPwCheck;//유효성 검사를 위한 String 멤버변수

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_email);
        ImageView ivBack = findViewById(R.id.iv_sign_up_keyboard_left);//'<' 뒤로가기
        ivBack.setOnClickListener(this);//'<' 뒤로가기
        Button btnLogin = findViewById(R.id.btn_sign_up_login);//로그인
        btnLogin.setOnClickListener(this);//로그인
//        EditText mEnterEmail = findViewById(R.id.et_sign_up_enter_email);//이메일 입력
//        EditText mEnterPw = findViewById(R.id.et_sign_up_enter_pw);//이메일 입력
//        EditText mEnterCheckPw = findViewById(R.id.et_sign_up_enter_check_pw);//이메일 입력


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //<기능> '<' 뒤로가기 버튼
            case R.id.iv_sign_up_keyboard_left:
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            //<기능>로그인 버튼
            case R.id.btn_sign_up_login:
                String emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";//이메일 유효성 검사
                String pwValidation = "^.*(?=^.{8,20}$)(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";//비밀번호 유효성 검사
                EditText mEnterEmail = findViewById(R.id.et_sign_up_enter_email);//이메일 입력
                EditText mEnterPw = findViewById(R.id.et_sign_up_enter_pw);//비밀번호 입력
                EditText mEnterCheckPw = findViewById(R.id.et_sign_up_enter_check_pw);//비밀번호 확인 입력

                mStrEmail = mEnterEmail.getText().toString();
                mStrPw = mEnterPw.getText().toString();
                mStrPwCheck = mEnterCheckPw.getText().toString();

                String alertEmail = "이메일 형식이 잘못되었습니다.";
                String alertPwLength = "비밀번호는 6글자 이상이어야 합니다.";
                String alertPwCheck = "두개의 비밀번호는 일치하지 않습니다.";

                //<조건> 1. 이메일만 미입력/잘못된형식 > 가입하기 > 이메일 형식이 잘못되었습니다.
                //<비고> matches를 비교할때는 [값matches유효성String]으로 진행해야한다.
                if (!(mStrEmail.matches(emailValidation))) {
                    sendAlertDialog(alertEmail);
                    return;
                }
                //<조건> 2. 비민번호 글자수미만/미입력 > 가입하기 > 비밀번호는 6글자 이상이어야 합니다.
                if (!(mStrPw.length() >= 6)) {
                    sendAlertDialog(alertPwLength);
                    return;
                }
                //<조건> 3. 비민번호 비교(불일치) > 가입하기 > 비밀번호는 6글자 이상이어야 합니다.
                if (!(mStrPw.equals(mStrPwCheck))) {
                    sendAlertDialog(alertPwCheck);
                    return;
                }
                //<통과> 유효성검사 PASS > 가입하기 > API
                //<구현대상> 회원가입 API
                else {
                    Toast.makeText(this, "API통신을 작업해야합니다.", Toast.LENGTH_SHORT).show();




                    return;
                }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
    }

    //다이얼로그
    //<기능> 유효성 검사에서 나오는 다이얼로그 창
    public void sendAlertDialog(String message) {
        String title = "열품타 회원가입";
        String positive = "확인";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title).setMessage(message);
        builder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }


}
