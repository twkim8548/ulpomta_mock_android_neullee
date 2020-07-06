package com.example.passion.src.SignIn.SingInStart;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.example.passion.R;
import com.example.passion.src.ApplicationClass;
import com.example.passion.src.BaseActivity;
import com.example.passion.src.MainFragment.FragmentStartActivity.FragmentStartActivity;
import com.example.passion.src.SignIn.FindEmailInPw.FindEmailInPwActivity;
import com.example.passion.src.SignIn.SingInStart.interfaces.SignInStartActivityView;

import static com.example.passion.src.ApplicationClass.sSharedPreferences;

public class SignInStartActivity extends BaseActivity implements SignInStartActivityView, View.OnClickListener {

    private EditText mEtEmail, mEtPW;//입력 : 이메일 / 비밀번호
    private String mStrEmail, mStrPW;//저장 : 이메일 / 비밀번호
    private SignInStartService mSignInStartService;//전역변수 : 서비스


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_start);
        mEtEmail = findViewById(R.id.et_sign_in_start_find_enter_email);
        mEtPW = findViewById(R.id.et_sign_in_start_find_enter_pw);
        TextView mFindPW = findViewById(R.id.tv_sign_in_start_find_pw);//비밀번호 찾기
        mFindPW.setOnClickListener(this);//비밀번호 찾기
        TextView mFindEmail = findViewById(R.id.tv_sign_in_start_find_email);//이메일 찾기
        mFindEmail.setOnClickListener(this);//이메일 찾기
        ImageView ivBack = findViewById(R.id.iv_sign_in_start_find_keyboard_left);//< 버튼
        ivBack.setOnClickListener(this);//< 버튼
        Button btnLogin = findViewById(R.id.btn_sign_in_start_find_login);//로그인 버튼
        btnLogin.setOnClickListener(this);//로그인 버튼
        mSignInStartService = new SignInStartService(this);//서비스 객체화
    }

    //<설명> 네트워크 작업
    private void tryPostSignIn() {
        showProgressDialog();
        mSignInStartService.postSingInStart(mStrEmail, mStrPW);
    }

    //<설명> 성공화면
    @Override
    public void signInStartSuccess(String jwt) {//오타수정완료
        hideProgressDialog();
        //<설명> ApplicationClass의 sSharedPreferences 를 이용한 헤더에 jwt 저장
        sSharedPreferences = getSharedPreferences("sSpf", MODE_PRIVATE);
        SharedPreferences.Editor editor = sSharedPreferences.edit();
        editor.putString(ApplicationClass.X_ACCESS_TOKEN, jwt);//헤더에 jwt 토큰값 넣는 부분!!!!
        editor.apply();

        Intent intent = new Intent(SignInStartActivity.this, FragmentStartActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        ActivityCompat.finishAffinity(SignInStartActivity.this);
    }


    //<설명> 실패화면
    @Override
    public void signInStartFailure(String message) {
        hideProgressDialog();

        if (message == null || message.isEmpty()) {//<기능>메세지값이 없을때
            showCustomToast(getString(R.string.network_error));
        } else {//<기능> 메세지값이있을때
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("로그인").setMessage(message);
            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        }
    }


    //<설명> 클릭모음
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //<기능> 로그인 버튼s
            case R.id.btn_sign_in_start_find_login:
                //<설명> 입력한 이메일/비밀번호
                mStrEmail = mEtEmail.getText().toString();
                mStrPW = mEtPW.getText().toString();

                //<설명> 이메일 비밀번호 유효성검사
                String emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                int pwLength = 6;
                //<설명> 다이얼로그 메세지 창
                //<수정> 실제 앱 : 인증되지 않은 이메일주소입니다. 메일 수신함에서 인증링크를 클릭해주세요
                //      -> 로그인에 맞지 않은 문구이기 때문에 클라에서 자체로 문구를 변경
                String emailMessage = "인증되지 않은 이메일주소입니다. 다시 입력해주세요";
                String pwMessage = "비밀번호가 일치하지 않습니다. 다시 확인해주세요";
                if (!(mStrEmail.matches(emailValidation))) {//<기능>이메일 형식이 안맞을때
                    signInAlertDialog(emailMessage);
                    break;
                }
                if (!(mStrPW.length() >= pwLength)) {//<기능>비밀번호 글자가 안맞을때
                    signInAlertDialog(pwMessage);
                    break;
                } else if (mStrEmail.matches(emailValidation) && mStrPW.length() >= pwLength) {//이메일과 비밀번호 형식이 모두 맞을때
                    tryPostSignIn();
                    break;
                }

                //<기능> 비밀번호 찾기
            case R.id.tv_sign_in_start_find_pw:
                Intent intent = new Intent(this, FindEmailInPwActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            //<기능> 이메일 찾기
            //[미구현]
            //닉네임을 입력하세요 => 사용자가 입력할 수 있도록 커스텀 다이얼로그를 설정해야한다
            case R.id.tv_sign_in_start_find_email:
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
            case R.id.iv_sign_in_start_find_keyboard_left:
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

    public void signInAlertDialog(String message) {
        String title = "로그인";
        String check = "확인";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title).setMessage(message);
        builder.setPositiveButton(check, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

}
