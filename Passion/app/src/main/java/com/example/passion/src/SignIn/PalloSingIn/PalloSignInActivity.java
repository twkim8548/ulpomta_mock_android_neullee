package com.example.passion.src.SignIn.PalloSingIn;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.example.passion.R;
import com.example.passion.src.BaseActivity;
import com.example.passion.src.Access.FragmentMain.FragmentMainActivity;
import com.example.passion.src.SignIn.PalloFindPW.PalloFindPwActivity;
import com.example.passion.src.SignIn.PalloMembershipEmail.PalloMembershipEmailActivity;
import com.example.passion.src.SignIn.PalloSingIn.interfaces.PalloSignInActivityView;

public class PalloSignInActivity extends BaseActivity implements PalloSignInActivityView, View.OnClickListener {

    private EditText mEtEmail, mEtPW;
    private String mStrEmail, mStrPW;
    private PalloSignInService palloSignInService;//전역변수 m 붙이는 것 => 통일성
    private TextView mFindPW, mFindEmail, mMembership; //전역변수가 아닌데 왜 전역변수를 했나? <수정필요


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallo_signi_in);
        mEtEmail = findViewById(R.id.et_palloSign_enterEmail);
        mEtPW = findViewById(R.id.et_palloSign_enterPW);
        mFindPW = findViewById(R.id.tv_palloSing_findPW);
        mFindPW.setOnClickListener(this);
        mFindEmail = findViewById(R.id.tv_palloSing_findEmail);
        mFindEmail.setOnClickListener(this);
        mMembership = findViewById(R.id.tv_palloSign_ToLogin);
        mMembership.setOnClickListener(this);

        palloSignInService = new PalloSignInService(this);
    }

    private void tryPostSignIn() {
        showProgressDialog();
        palloSignInService.postSingIn(mStrEmail, mStrPW);
    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void signInSuccess(boolean isSucess, String message) {//오타수정
        hideProgressDialog();
        if (isSucess == true) {//isSuccess 자체가 boolean형태 <수정하기>
            Intent intent = new Intent(PalloSignInActivity.this, FragmentMainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fadein,R.anim.fadeout);
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

    //클릭 기능을 나눌필요가 없어 보인다.
    //SWITCH는 여러가지 기능을 넣지만 하나만 있다
    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_palloSing_Login:
                mStrEmail = mEtEmail.getText().toString();
                mStrPW = mEtPW.getText().toString();
                tryPostSignIn();
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_palloSing_findPW:
                Intent intent = new Intent(this, PalloFindPwActivity.class);
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                startActivity(intent);
                break;
            case R.id.tv_palloSing_findEmail:
                Toast.makeText(this, "개발중", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_palloSign_ToLogin://스네이크 케이스 : 모두 소문자로 사용해야함
                Intent intent1 = new Intent(this, PalloMembershipEmailActivity.class);
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                startActivity(intent1);
            default:
                break;
        }
    }
}
