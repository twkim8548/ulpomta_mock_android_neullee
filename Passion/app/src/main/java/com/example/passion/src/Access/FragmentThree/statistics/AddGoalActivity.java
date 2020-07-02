package com.example.passion.src.Access.FragmentThree.statistics;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.passion.R;

public class AddGoalActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBack;
    private TextView mAdd;
    private EditText mContents;
    private Button mColor;
    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);

        mBack = findViewById(R.id.iv_addGoal_keyboard_left);
        mAdd = findViewById(R.id.tv_addGoal_add);
        mContents = findViewById(R.id.et_addGoal_input);
        mColor = findViewById(R.id.btn_addGoal_circle);

        mBack.setOnClickListener(this);
        mColor.setOnClickListener(this);

        //추가버튼 > 앱이 터지는 부분은 없지만 intent 작동이 안됨
//        mAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mName = mContents.getText().toString();
//                Intent intent = new Intent(AddGoalActivity.this, FragThreeActivity.class);
//                intent.putExtra("AddSubject",mName);
//                startActivity(intent);
//                finish();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_addGoal_keyboard_left:
                finish();
                break;
            case R.id.tv_addGoal_add:
                Toast.makeText(this, "개발중입니다.", Toast.LENGTH_SHORT).show();
//                  Fragment는 해당 onClick이 안됨
//                mName = mContents.getText().toString();
//                Intent intent = new Intent(AddGoalActivity.this, FragThreeActivity.class);
//                intent.putExtra("AddSubject",mName);
//                startActivity(intent);
                finish();
                break;
            case R.id.btn_addGoal_circle:
                Toast.makeText(this, "개발중입니다.", Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                break;
        }
    }
}
