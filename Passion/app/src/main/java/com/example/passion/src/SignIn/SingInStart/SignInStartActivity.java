package com.example.passion.src.SignIn.SingInStart;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.example.passion.R;
import com.example.passion.src.TimerFragment.FragmentStartActivity.FragmentStartActivity;
import com.example.passion.src.BaseActivity;
import com.example.passion.src.SignIn.FindPW.FindPwActivity;
import com.example.passion.src.SignIn.SingInStart.interfaces.SignInStartActivityView;

public class SignInStartActivity extends BaseActivity implements SignInStartActivityView, View.OnClickListener {

    private EditText mEtEmail, mEtPW;//입력 : 이메일 / 비밀번호
    private String mStrEmail, mStrPW;//저장 : 이메일 / 비밀번호
    private SignInStartService signInStartService;//전역변수 : 서비스


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_start);
        mEtEmail = findViewById(R.id.et_palloSign_enterEmail);
        mEtPW = findViewById(R.id.et_palloSign_enterPW);
        TextView mFindPW = findViewById(R.id.tv_palloSing_findPW);//비밀번호 찾기
        mFindPW.setOnClickListener(this);//비밀번호 찾기
        TextView mFindEmail = findViewById(R.id.tv_palloSing_findEmail);//이메일 찾기
        mFindEmail.setOnClickListener(this);//이메일 찾기
        ImageView ivBack = findViewById(R.id.iv_palloSign_keyboard_left);//< 버튼
        ivBack.setOnClickListener(this);//< 버튼
        Button btnLogin = findViewById(R.id.btn_palloSing_Login);//로그인 버튼
        btnLogin.setOnClickListener(this);//로그인 버튼
        signInStartService = new SignInStartService(this);//서비스 객체화
    }

    //<설명> 네트워크 작업
    private void tryPostSignIn() {
        showProgressDialog();
        signInStartService.postSingIn(mStrEmail, mStrPW);
    }

    //<설명> 실패하면>
    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    //<설명> 성공화면
    @Override
    public void signInSuccess(boolean isSucess, String message) {//오타수정
        hideProgressDialog();
        if (isSucess) {//<수정완료> isSucess = ture -> isSuccess 자체가 boolean형태
            Intent intent = new Intent(SignInStartActivity.this, FragmentStartActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            ActivityCompat.finishAffinity(SignInStartActivity.this);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("로그인").setMessage(message);
            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.create().show();
        }
    }

    //<설명> 클릭모음
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //<기능> 로그인 버튼s
            case R.id.btn_palloSing_Login:
                mStrEmail = mEtEmail.getText().toString();
                mStrPW = mEtPW.getText().toString();
                tryPostSignIn();
                break;
            //<기능> 비밀번호 찾기
            case R.id.tv_palloSing_findPW:
                Intent intent = new Intent(this, FindPwActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            //<기능> 이메일 찾기
            //[미구현]
            //닉네임을 입력하세요 => 사용자가 입력할 수 있도록 커스텀 다이얼로그를 설정해야한다

            case R.id.tv_palloSing_findEmail:
                String title = "이메일 찾기",
                        hintContents = "닉네임을 입력하세요",
                        cancel = "취소",
                        check = "확인";
                AlertDialog.Builder builder = new AlertDialog.Builder(this);//this = v.getContext
                builder.setTitle(title).setMessage(hintContents);
                builder.setPositiveButton(check, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SignInStartActivity.this, "네트워크 통신을 해야합니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton(cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
                break;

            //<기능> <- 버튼
            case R.id.iv_palloSign_keyboard_left:
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
                break;
            default:
                break;
        }
    }

    //<기능> 핸드폰 < 클릭
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
    }
}
