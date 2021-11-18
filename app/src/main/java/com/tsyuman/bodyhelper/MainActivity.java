package com.tsyuman.bodyhelper;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);             // Butter Knife start

        setupMenu();
    }

    private void setupMenu() {
        FragmentManager fm = getSupportFragmentManager();
        MenuFragmentList mMenuFragment = (MenuFragmentList) fm.findFragmentById(R.id.id_container_menu);
        if (mMenuFragment == null) {
            mMenuFragment = new MenuFragmentList();
            fm.beginTransaction().add(R.id.id_container_menu, mMenuFragment).commit();
        }
    }
}