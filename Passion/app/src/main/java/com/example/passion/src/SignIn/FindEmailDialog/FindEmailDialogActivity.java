package com.example.passion.src.SignIn.FindEmailDialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.passion.R;
import com.example.passion.src.BaseActivity;
import com.example.passion.src.SignIn.FindEmailDialog.DialogInterface.SignInStartDialogClickListener;
import com.example.passion.src.SignIn.FindEmailDialog.interfaces.FindEmailDialogActivityView;
import com.example.passion.src.SignIn.FindEmailDialog.models.UserInfo;

public class FindEmailDialogActivity extends BaseActivity implements FindEmailDialogActivityView, View.OnClickListener {

    //    private Context mContext;
    private SignInStartDialogClickListener mSignInStartDialogClickListener;//인터페이스

    private EditText mEnterNickname;
    private TextView mEnterNicknameHint;
    private String mNickname;
    private FindEmailDialogService findEmailDialogService;

    public void getSingInStartDialog() {
        showCustomProgressDialog();
        findEmailDialogService = new FindEmailDialogService(this);
        findEmailDialogService.getSingInStartDialog(mNickname);
    }

    @Override
    public void signInStartDialogSuccess(UserInfo userInfo) {
        hideCustomProgressDialog();
        sendAlertDialog("이메일 : " + userInfo.getEmail() + "\n\n\n" + "가입날짜 : \n" + userInfo.getCreatedAt());
    }

    @Override
    public void signInStartDialogFailure(UserInfo userInfo) {
        hideCustomProgressDialog();
        sendAlertDialog("일치하는 이메일 계정이 없습니다.");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_email_dialog);

        //닉네임 입력
        mEnterNickname = findViewById(R.id.et_sign_in_start_dialog_enter_nickname);
        mEnterNickname.setOnClickListener((View.OnClickListener) this);

        //취소
        TextView mCancel = findViewById(R.id.tv_sign_in_start_dialog_cancel);
        mCancel.setOnClickListener((View.OnClickListener) this);
        //확인
        TextView mCheck = findViewById(R.id.tv_sign_in_start_dialog_check);
        mCheck.setOnClickListener((View.OnClickListener) this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //<기능> 취소버튼
            case R.id.tv_sign_in_start_dialog_cancel:
                finish();
                break;
            //<기능> 확인버튼
            case R.id.tv_sign_in_start_dialog_check:
                //닉네임 저장 및 네트워크 통신
                mNickname = mEnterNickname.getText().toString();
                getSingInStartDialog();
                break;
        }
    }


    //다이얼로그
    //<기능> 유효성 검사에서 나오는 다이얼로그 창
    public void sendAlertDialog(String message) {
        String title = "이메일 찾기";
        String positive = "확인";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title).setMessage(message);
        builder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(R.color.colorWhite);
        builder.show();
    }


}
