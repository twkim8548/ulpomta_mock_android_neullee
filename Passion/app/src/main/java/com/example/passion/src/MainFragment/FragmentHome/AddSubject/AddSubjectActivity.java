package com.example.passion.src.MainFragment.FragmentHome.AddSubject;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.passion.R;
import com.example.passion.src.BaseActivity;
import com.example.passion.src.MainFragment.FragmentHome.AddSubject.interfaces.AddSubjectActivityView;

public class AddSubjectActivity extends BaseActivity implements AddSubjectActivityView, View.OnClickListener {

    private String mName;
    private TextView tvAddSubject;
    private String mStrSubject;
    private EditText mEtEnterContents;
    private AddSubjectService mAddSubjectService;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        ivBack = findViewById(R.id.iv_add_subject_keyboard_left);//'<' 뒤로가기
        ivBack.setOnClickListener(this);//'<' 뒤로가기
        tvAddSubject = findViewById(R.id.tv_addGoal_add);//추가 클릭
        tvAddSubject.setOnClickListener(this);
        mEtEnterContents = findViewById(R.id.et_addGoal_input);//입력내용
        Button btnColor = findViewById(R.id.btn_addGoal_circle);//색상 선택
        btnColor.setOnClickListener(this);//색상 선택
        mAddSubjectService = new AddSubjectService(this);
    }

    private void tryPostAddSubject() {
        showCustomProgressDialog();
        mAddSubjectService.postAddSubject(mStrSubject); //입력한 과목 이름을 넣어준다
    }

    @Override
    public void addSubjectFailure(String message) {
        hideCustomProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void addSubjectSuccess(String message) {
        hideCustomProgressDialog();
        //입력한 과목을 SharedPreference에 저장한다
        SharedPreferences spf = getSharedPreferences("spf", MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.putString("subjectName", mStrSubject);
        editor.apply();

        //과목 추가 > 성공 > 입력한 과목을 FragmentHome 의 리스뷰에 표기가 된다
        //<설명> FragmentHome 으로 이동한다.
        finish();
    }

    @Override
    public void onClick(View v) {
        //애니메이션
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);

        switch (v.getId()) {
            //<기능> '<' 뒤로가기 버튼
            //<설명> 과목추가 > '<' 클릭 >
            case R.id.iv_add_subject_keyboard_left:
                //버튼 애니메이션
                ivBack.startAnimation(animation);

                SharedPreferences spf = getSharedPreferences("spf", MODE_PRIVATE);
                SharedPreferences.Editor editor = spf.edit();
                editor.clear();
                editor.apply();
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
                break;
            //<기능> 추가 버튼
            //<설명> 입력한 과목을 서버 저장 후 리사이클러뷰 목록에 이름으로 보냅니다.
            case R.id.tv_addGoal_add:
                //버튼 애니메이션
                tvAddSubject.startAnimation(animation);

                //입력한 과목 변수저장
                mStrSubject = mEtEnterContents.getText().toString();
                //<기능> 입력한 과목 '전달'
                if (mStrSubject.length() > 0) {
                    tryPostAddSubject();//<설명> 과목 생성 API : POST
                } else {//<기능> 과목 입력 없음 : 다이얼로그
                    //<설명> 다이얼로그
                    String title = "과목추가";
                    String message = "1글자 이상이어야 합니다.";
                    String positive = "확인";
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(title).setMessage(message);
                    builder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                }
                break;
            case R.id.btn_addGoal_circle:
                Toast.makeText(this, "시간이 남으면 개발예정입니다.", Toast.LENGTH_SHORT).show();
                SharedPreferences spf1 = getSharedPreferences("spf", MODE_PRIVATE);
                SharedPreferences.Editor editor1 = spf1.edit();
                editor1.clear();
                editor1.apply();
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SharedPreferences spf = getSharedPreferences("spf", MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.clear();
        editor.apply();
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);//애니메이션 => 베이스에 넣을 수 있는 지 확인하기
    }
}
