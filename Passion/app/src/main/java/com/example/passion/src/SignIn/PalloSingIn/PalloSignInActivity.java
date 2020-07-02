package com.example.passion.src.SignIn.PalloSingIn;

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
import com.example.passion.src.Access.FragmentMain.FragmentMainActivity;
import com.example.passion.src.BaseActivity;
import com.example.passion.src.SignIn.PalloFindPW.PalloFindPwActivity;
import com.example.passion.src.SignIn.PalloMembershipEmail.PalloMembershipEmailActivity;
import com.example.passion.src.SignIn.PalloSingIn.interfaces.PalloSignInActivityView;

public class PalloSignInActivity extends BaseActivity implements PalloSignInActivityView, View.OnClickListener {

    private EditText mEtEmail, mEtPW;//입력 : 이메일 / 비밀번호
    private String mStrEmail, mStrPW;//저장 : 이메일 / 비밀번호
    private PalloSignInService palloSignInService;//전역변수 : 서비스

    private String mTitle = "이메일 찾기",
            mHintContens = "닉네임을 입력하세요",
            mCancel = "취소",
            mCheck = "확인";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallo_sign_in);
        mEtEmail = findViewById(R.id.et_palloSign_enterEmail);
        mEtPW = findViewById(R.id.et_palloSign_enterPW);
        TextView mFindPW = findViewById(R.id.tv_palloSing_findPW);//비밀번호 찾기
        mFindPW.setOnClickListener(this);//비밀번호 찾기
        TextView mFindEmail = findViewById(R.id.tv_palloSing_findEmail);//이메일 찾기
        mFindEmail.setOnClickListener(this);//이메일 찾기
        TextView mMembership = findViewById(R.id.tv_palloSign_ToLogin);//가입하기
        mMembership.setOnClickListener(this);//가입하기
        ImageView btnBack = findViewById(R.id.iv_palloSign_keyboard_left);//< 버튼
        btnBack.setOnClickListener(this);//< 버튼
        Button btnLogin = findViewById(R.id.btn_palloSing_Login);//로그인 버튼
        btnLogin.setOnClickListener(this);//로그인 버튼
        palloSignInService = new PalloSignInService(this);//서비스 객체화
    }

    //<설명> 네트워크 작업
    private void tryPostSignIn() {
        showProgressDialog();
        palloSignInService.postSingIn(mStrEmail, mStrPW);
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
            Intent intent = new Intent(PalloSignInActivity.this, FragmentMainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            ActivityCompat.finishAffinity(PalloSignInActivity.this);
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
                Intent intent = new Intent(this, PalloFindPwActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            //<기능> 이메일 찾기
            //[미구현]
            case R.id.tv_palloSing_findEmail:
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle(mTitle).setMessage(mHintContens);
                builder.setPositiveButton(mCheck, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(PalloSignInActivity.this, "네트워크 통신을 해야합니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton(mCancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                break;
            //<기능> 가입하기
            case R.id.tv_palloSign_ToLogin://스네이크 케이스 : 모두 소문자로 사용해야함
                Intent intent1 = new Intent(this, PalloMembershipEmailActivity.class);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                startActivity(intent1);
                //<기능> <- 버튼
            case R.id.iv_palloSign_keyboard_left:
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
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
