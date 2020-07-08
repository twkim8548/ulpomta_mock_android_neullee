package com.example.passion.src.MainFragment.FragmentHome.Drawer;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.passion.R;

public class DrawerMainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_main);

        toolbar = findViewById(R.id.drawer_tool_bar);
        drawerLayout = findViewById(R.id.drawer_layout);

    }
}
