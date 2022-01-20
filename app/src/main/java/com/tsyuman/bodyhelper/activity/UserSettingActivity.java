package com.tsyuman.bodyhelper.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.tsyuman.bodyhelper.R;

import java.util.stream.Stream;

public class UserSettingActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUserName;
    private EditText etUserSurname;
    private EditText etUserCurrentWeigh;
    private EditText etUserDesiredWeight;
    private EditText etUserCaloriesPerDay;
    private EditText etUserNumberOfMeals;

    private Button btnModify;
    private Button btnBack;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);

        customFindViewById();
        Stream
                .of(btnModify, btnBack)
                .forEach(btn -> btn.setOnClickListener(this));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if (v.getId() == btnModify.getId()) {
            Stream
                    .of(    etUserName,
                            etUserSurname,
                            etUserCurrentWeigh,
                            etUserDesiredWeight,
                            etUserCaloriesPerDay,
                            etUserNumberOfMeals)
                    .forEach(et -> {
                        et.setFocusable(true);
                        et.setClickable(true);
                        et.setCursorVisible(true);
                    });
        }

        if (v.getId() == btnBack.getId()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void customFindViewById() {
        etUserName = findViewById(R.id.id_etUserName_userSettingActivity);
        etUserSurname = findViewById(R.id.id_etUserSurname_userSettingActivity);
        etUserCurrentWeigh = findViewById(R.id.id_etCurrentWeight_UserSettingActivity);
        etUserDesiredWeight = findViewById(R.id.id_etDesiredWeight_userSettingActivity);
        etUserCaloriesPerDay = findViewById(R.id.id_etCaloriesPerDay_UserSettingActivity);
        etUserNumberOfMeals = findViewById(R.id.id_etNumberOfMeals_UserSettingActivity);

        btnModify = findViewById(R.id.id_btn_modify_userSettingActivity);
        btnBack = findViewById(R.id.id_btn_back_userSettingActivity);
    }

    private void saveUser() {
        //TODO реализовать сохранение пользователя
    }

}