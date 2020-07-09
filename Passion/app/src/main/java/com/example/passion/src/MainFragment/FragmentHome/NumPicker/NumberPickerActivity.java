package com.example.passion.src.MainFragment.FragmentHome.NumPicker;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.passion.R;

public class NumberPickerActivity extends Dialog implements View.OnClickListener {

    NumberPicker nNumberPicker;
    TextView cancel, check;
    Context mContext;

    public NumberPickerActivity(@NonNull Context context) {
        super(context);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker);
        nNumberPicker = findViewById(R.id.num_picker);

        cancel = findViewById(R.id.cancel);
        check = findViewById(R.id.check);

        nNumberPicker.setMaxValue(1);
        nNumberPicker.setMaxValue(60);
        nNumberPicker.setValue(10);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.num_picker:

                break;
            case R.id.cancel:
                dismiss();

                break;
            case R.id.check:
                //알림설정

                break;

        }
    }
}
