package com.example.passion.src.PalloSingIn;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.example.passion.R;
import com.example.passion.src.BaseActivity;
import com.example.passion.src.FragmentMain.MainActivity;
import com.example.passion.src.PalloSingIn.interfaces.PalloSignInActivityView;

public class PalloSignInActivity extends BaseActivity implements PalloSignInActivityView {

    private EditText mEtEmail, mEtPW;
    String mStrEmail, mStrPW;
    private PalloSignInService palloSignInService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallo_signi_in);
        mEtEmail = findViewById(R.id.et_palloSign_enterEmail);
        mEtPW = findViewById(R.id.et_palloSign_enterPW);

        palloSignInService = new PalloSignInService(this);
    }

    private void tryPostSignIn() {
        showProgressDialog();
        palloSignInService.postSingIn(mStrEmail, mStrPW);
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
        //성공뒤 다이얼로그 해제 후 [작동]
    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void signInSuccess(boolean isSucess, String message) {
        hideProgressDialog();
        if (isSucess == true) {
            Intent intent = new Intent(PalloSignInActivity.this, MainActivity.class);
            startActivity(intent);
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


}
