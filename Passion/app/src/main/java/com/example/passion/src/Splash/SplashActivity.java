package com.example.passion.src.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.passion.R;
import com.example.passion.src.Splash.interfaces.SplashActivityView;
import com.example.passion.src.BaseActivity;
import com.example.passion.src.MainFragment.FragmentStartActivity.FragmentStartActivity;
import com.example.passion.src.SignIn.StartActivity;

public class SplashActivity extends BaseActivity implements SplashActivityView {

    private SplashService mSplashService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);

        mSplashService = new SplashService(this);
        getCheckJwt();
    }

    //<설명> 네트워크 작업
    private void getCheckJwt() {
        showProgressDialog();
        mSplashService.getCheckJwt();
    }

    @Override
    public void checkJwtSuccess(int code) {
        Toast.makeText(this, "성공", Toast.LENGTH_SHORT).show();
        showProgressDialog();

        Intent intent = new Intent(this, FragmentStartActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void checkJwtFailure(String message) {
        Toast.makeText(this, "실패", Toast.LENGTH_SHORT).show();
        showProgressDialog();

        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
    }
}
