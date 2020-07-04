package com.example.passion.src.SignIn.SingInStart.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.passion.R;
import com.example.passion.src.SignIn.SingInStart.Dialog.DialogInterface.SignInStartDialogClickListener;

public class SignInStartDialog extends Dialog implements View.OnClickListener {

    private Context mContext;
    private SignInStartDialogClickListener mSignInStartDialogClickListener;//인터페이스

    EditText mEnterNickname;
    private String mNickname;

    //생성자
    public SignInStartDialog(@NonNull Context mContext, SignInStartDialogClickListener mSignInStartDialogClickListener) {
        super(mContext);
        this.mContext = mContext;
        this.mSignInStartDialogClickListener = mSignInStartDialogClickListener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_start_dialog);
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
                dismiss();
                break;
            //<기능> 확인버튼
            case R.id.tv_sign_in_start_dialog_check:
                mNickname = mEnterNickname.getText().toString();//입력한 닉네임 저장
                String alertMessage = "이메일 : 78********";//유효성검사 멘트
                //데이터 통신작업

                //네트워크 통신에서 : 이메일 / 가입날짜가
                sendAlertDialog("이메일"+"이메일변수"+"가입날짜"+"가입날짜변수");






                break;
        }

    }


    //다이얼로그
    //<기능> 유효성 검사에서 나오는 다이얼로그 창
    public void sendAlertDialog(String message) {
        String title = "이메일 찾기";
        String positive = "확인";

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
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
