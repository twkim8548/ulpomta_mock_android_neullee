package com.example.passion.src;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.CustomCircleProgressBar;
import com.example.passion.R;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    public ProgressDialog mProgressDialog;
    public CustomCircleProgressBar customCircleProgressBar;

    public void showCustomToast(final String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public void showCustomProgressDialog(){
        if (customCircleProgressBar == null) {
            customCircleProgressBar = new CustomCircleProgressBar(this);
            customCircleProgressBar.setCancelable(false);
        }
        customCircleProgressBar.getWindow().setBackgroundDrawable(new ColorDrawable());
        customCircleProgressBar.show();
    }

    public void hideCustomProgressDialog(){
        if (customCircleProgressBar != null && customCircleProgressBar.isShowing()) {
            customCircleProgressBar.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }
}
