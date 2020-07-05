package com.example.passion.src.MainFragment.FragmentHome.NavigationDrawer;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.passion.R;

public class DrawerMain extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_main);

        toolbar = findViewById(R.id.drawer_tool_bar);
        drawerLayout = findViewById(R.id.drawer_layout);

    }
}
