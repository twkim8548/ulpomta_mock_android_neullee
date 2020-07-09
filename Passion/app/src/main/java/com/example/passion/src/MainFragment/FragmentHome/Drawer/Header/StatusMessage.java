package com.example.passion.src.MainFragment.FragmentHome.Drawer.Header;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;

public class StatusMessage extends AppCompatActivity implements View.OnClickListener,TextWatcher {

    private ImageView mIvBack;
    private EditText mEtStatus;
    private TextView mTvLength;
    private String length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_message);
        //뒤로가기버튼
        mIvBack = findViewById(R.id.iv_status_keyboard_left);
        mIvBack.setOnClickListener(this);

        //상태메세지 입력할 때마다 표시하기
        mEtStatus = findViewById(R.id.et_enter_status_message);
        mTvLength = findViewById(R.id.tv_status_length);
        mEtStatus.addTextChangedListener(this);

        //변경하기
        Button btnStatusMessage = findViewById(R.id.btn_status_commit);
        btnStatusMessage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_status_keyboard_left:
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

                //변경하기 버튼 클릭
            case R.id.btn_status_commit:
                if (length!=null) {
                    length = mEtStatus.getText().toString();
                    SharedPreferences spf = getApplicationContext().getSharedPreferences("spf_status", MODE_PRIVATE);
                    SharedPreferences.Editor editor = spf.edit();
                    editor.putString("status", length);
                    editor.commit();

                    finish();
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                } else {
                    Toast.makeText(this, "상태 메세지를 넣어주세요", Toast.LENGTH_SHORT).show();
                    finish();
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SharedPreferences spf = getSharedPreferences("spf_status", MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.clear();
        editor.commit();
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        mTvLength.setText("'0/200Bytes");

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        length = mEtStatus.getText().toString();
        mTvLength.setText(length.length() + "/200Bytes");
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
