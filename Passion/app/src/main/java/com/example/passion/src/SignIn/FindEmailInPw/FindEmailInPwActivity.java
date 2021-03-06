package com.example.passion.src.SignIn.FindEmailInPw;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.passion.R;
import com.example.passion.src.BaseActivity;
import com.example.passion.src.SignIn.FindEmailInPw.SendEmail.SendEmailActivity;
import com.example.passion.src.SignIn.FindEmailInPw.interfaces.FindEmailInPwActivityView;

public class FindEmailInPwActivity extends BaseActivity implements FindEmailInPwActivityView, View.OnClickListener {

    //멤버변수
    private EditText mEtEmail; //이메일 입력
    private String mStrEmail;//입력한 이메일 저장
    private FindEmailInPwService mFindEmailInPwService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pw);
        //'<' 뒤로가기 버튼
        ImageView ivBack = findViewById(R.id.iv_find_pw_keyboard_left);
        ivBack.setOnClickListener(this);
        //이메일 입력
        mEtEmail = findViewById(R.id.et_find_pw_enter_Email);
        //이메일계정확인
        Button BtnFindPW = findViewById(R.id.btn_nickname_change);
        BtnFindPW.setOnClickListener(this);
        //서비스 객체화
        mFindEmailInPwService = new FindEmailInPwService(this);
    }

    private void getFindEmailInPw(String email) {
        showCustomProgressDialog();
        //입력한 이메일을 서비스에 넣어준다
        mFindEmailInPwService.getFindEmailInPw(email);
    }

    @Override
    public void FindEmailPwSuccess(String message) {
        Toast.makeText(this, "성공화면", Toast.LENGTH_SHORT).show();
        hideCustomProgressDialog();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("이메일계정확인").setMessage(message);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), SendEmailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void FindEmailPwFailure(String message) {
        Toast.makeText(this, "실패화면", Toast.LENGTH_SHORT).show();

        hideCustomProgressDialog();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("이메일계정확인").setMessage(message);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //<기능> '<' 뒤로가기 버튼
            case R.id.iv_find_pw_keyboard_left:
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            //<기능> '이메일 계정확인' 버튼을 누르면 자체적으로 유효성검사 후 네트워크 통신을 통해 알럿창이 확인됩니다.
            case R.id.btn_nickname_change:
                //<기능> 입력한 email 저장
                String email = mEtEmail.getText().toString();

                //유효성 검사
                String emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                String Title = "이메일 계정확인";
                String Contents = "이메일 형식이 잘못되었습니다.";
                String Check = "확인";

                //<기능> email의 유효성 검사를 알럿창을 통해 보여준다
                //<설명> 이메일 유효성검사 true & 입력한 글자 수가 1글자 이상
                if (email.matches(emailValidation)) {
                    getFindEmailInPw(email);
                    break;
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setTitle(Title);
                    builder.setMessage(Contents);
                    builder.setPositiveButton(Check, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                    break;
                }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }


}
