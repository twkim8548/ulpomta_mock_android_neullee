package com.example.passion.src.StartActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;
import com.example.passion.src.MainFragment.FragmentStartActivity.FragmentStartActivity;

import static com.example.passion.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.passion.src.ApplicationClass.sSharedPreferences;

public class AppStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);
        //<설명> 저장한 SharedPreferecnes를 가져와 비교한다
        sSharedPreferences = getSharedPreferences(X_ACCESS_TOKEN, MODE_PRIVATE);
        String jwt = sSharedPreferences.getString(X_ACCESS_TOKEN, null);

        //서버에 JWT를 검증을해야한다다

       if (jwt == null) {
            //프로그레스바

            // 로그인 요구 화면
            Intent intent = new Intent(this, StartActivity.class);
            startActivity(intent);
            finish();

        } else {// 로그인 이후 화면(즉, 자동로그인 화면)
            Intent intent = new Intent(this, FragmentStartActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
