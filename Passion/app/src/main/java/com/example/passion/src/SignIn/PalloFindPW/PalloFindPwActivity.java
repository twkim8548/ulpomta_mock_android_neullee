package com.example.passion.src.SignIn.PalloFindPW;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.passion.R;
import com.example.passion.src.BaseActivity;
import com.example.passion.src.SignIn.PalloSingIn.interfaces.PalloSignInActivityView;

public class PalloFindPwActivity extends BaseActivity implements PalloSignInActivityView, View.OnClickListener {

    //멤버변수
    private EditText mEtEmail; //이메일 입력

    //유효성 검사
    private String mEmailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private String mTitle = "이메일 계정확인";
    private String mContents = "이메일 형식이 잘못되었습니다.";
    private String mCheck = "확인";
    private ImageView mBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallo_find_pw);
        Button BtnFindPW = findViewById(R.id.btn_palloFindPW_Login); //패스워드를 찾는 버튼
        mEtEmail = findViewById(R.id.et_palloFindPW_enterEmail);
        mBack = findViewById(R.id.iv_palloMember_keyboard_left);

        BtnFindPW.setOnClickListener(this);
        mBack.setOnClickListener(this);
    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void signInSuccess(boolean isSucess, String message) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //<배경> 해당 화면에는 버튼 하나만 클릭을 하기 때문에 setOnclickListener과 new를 배정
            //<기능> '이메일 계정확인' 버튼을 누르면 알럿창이 확인됩니다.
            case R.id.btn_palloFindPW_Login:
                //<기능> 입력한 email 저장
                String email = mEtEmail.getText().toString();

                //<기능> email의 유효성 검사를 알럿창을 통해 보여준다
                //<설명> 이메일 유효성검사 true & 입력한 글자 수가 1글자 이상
                if (email.matches(mEmailValidation)) {
                    //<기능> 네트워크 통신
                    //<설명>
                    Toast.makeText(PalloFindPwActivity.this, "개발중", Toast.LENGTH_SHORT).show();
                }
                if (!(email.matches(mEmailValidation))) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setTitle(mTitle);
                    builder.setMessage(mContents);
                    builder.setPositiveButton(mCheck, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                }
                break;

            case R.id.iv_palloMember_keyboard_left:
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
