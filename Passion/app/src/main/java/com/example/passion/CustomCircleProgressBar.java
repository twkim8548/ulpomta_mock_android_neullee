package com.example.passion;

        import android.app.Dialog;
        import android.content.Context;
        import android.view.Window;

        import androidx.annotation.NonNull;

public class CustomCircleProgressBar extends Dialog {

    public CustomCircleProgressBar(@NonNull Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // No Title
        setContentView(R.layout.activity_custom_circle_progress_bar);
    }
}
