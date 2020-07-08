package com.example.passion.src.MainFragment.FragmentHome.ToolBar.PhoneLock;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;

public class PhoneLock extends AppCompatActivity {

    private ImageView ivBack;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_lock);

        //뒤로가기 버튼
        ivBack = findViewById(R.id.iv_phone_lock_keyboard_left);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                alertHandel();
            }
        }, 1000);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
    }

    private void alertHandel() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("폰잠금");
        builder.setMessage("\n이 기능은 베타 테스트 중입니다.\n테스트 기간 중에는 최대 5시간 동안만 잠글 수 있습니다." +
                "\n\n기종에 따라 정상 작동 하지 않을 수 있습니다." +
                "\n문제있을시" +
                "\n\npallo.ypt@gmail.com로 메일주세요\n\n");
        builder.setPositiveButton("확인", null);
        builder.show();
    }

}
