package com.example.passion.src.MainFragment.FragmentHome.Drawer.Menu.Function.Nickname;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;

public class NickNameActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEtEnterNickname;
    String mStrEnterNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nick_name);
        //뒤로가기
        ImageView ivBack = findViewById(R.id.iv_function_keyboard_left);
        ivBack.setOnClickListener(this);

        //변경하기
        Button btnChange = findViewById(R.id.btn_nickname_change);
        btnChange.setOnClickListener(this);

        mEtEnterNickname = findViewById(R.id.et_nickname_enter);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //뒤로가기
            case R.id.iv_function_keyboard_left:
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
                break;
            //변경하기
            case R.id.btn_nickname_change:
                mStrEnterNickname = mEtEnterNickname.getText().toString();

                if (mStrEnterNickname.length() < 2) {
                    alertDialogNickName("닉네임 설정", "닉네임은 2글자 이상이어야 합니다.", "확인");
                } else {
                    Toast.makeText(this, "API 사용 예정입니다.", Toast.LENGTH_SHORT).show();
                    finish();
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
                }
                break;
        }
    }

    private void alertDialogNickName(String title, String message, String check) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title).setMessage(message);
        builder.setPositiveButton(check, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }

}
