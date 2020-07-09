package com.example.passion.src.SignIn.FindEmailInPw.SendEmail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;
import com.example.passion.src.SignIn.FindEmailInPw.SendEmail.CheckMessageOne.CheckActivity;

public class SendEmailActivity extends AppCompatActivity implements View.OnClickListener {

    EditText sendEmail;
    Button sendBtn;
    TextView mCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        sendEmail = findViewById(R.id.et_send_email);
        sendBtn = findViewById(R.id.btn_send_email);
        mCheck = findViewById(R.id.tv_change_message);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //이메일 입력
            case R.id.et_send_email:
                sendEmail.setBackgroundResource(R.drawable.box_orange);
                break;

            //전송 버튼
            case R.id.btn_send_email:
                String email = sendEmail.getText().toString();
                //유효성 검사
                String emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

                if (email == null) {
                    mCheck.setVisibility(View.VISIBLE);
                }
                //<기능> email의 유효성 검사를 알럿창을 통해 보여준다
                //<설명> 이메일 유효성검사 true & 입력한 글자 수가 1글자 이상
                if (email.matches(emailValidation)) {
                    Intent intent = new Intent(this, CheckActivity.class);
                    startActivity(intent);

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("이메일 계정확인").setMessage("API를 만드는 중입니다.");

                    break;
                }
                if (!(email.matches(emailValidation))) {
                    mCheck.setText("Enter a valid email address.");
                }
                break;
        }
    }
}
