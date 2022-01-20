package com.tsyuman.bodyhelper.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.tsyuman.bodyhelper.R;

import java.util.stream.Stream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.id_tv_userName_mainActivity)
    TextView txUserName;

    @BindView(R.id.id_btn_recipes_mainActivity)
    Button btnRecipes;

    @BindView(R.id.id_btn_shoppingList_mainActivity)
    Button btnShoppingList;

    @BindView(R.id.id_btn_userSetting_mainActivity)
    Button btnUserSetting;

    @BindView(R.id.id_btn_setting_mainActivity)
    Button btnSetting;

    SharedPreferences preferences;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);             // Butter Knife start

        // прем текста от предыдущего активити через Интент с помощью getStringExtra
//        Intent intent = getIntent(); // Получаем интент со стартового активити в котором есть передаваемый текст
//        String userName = intent.getStringExtra("userName"); // получаем имя пользователя по ключу.

        Stream.of(btnRecipes, btnShoppingList, btnUserSetting, btnSetting)
                .forEach(btn -> btn.setOnClickListener(this));

        loadText(txUserName);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnRecipes.getId()) {
            startNewActivity(RecipesActivity.class);

        } else if (v.getId() == btnShoppingList.getId()) {
            startNewActivity(ShoppingListActivity.class);

        } else if (v.getId() == btnUserSetting.getId()) {
            startNewActivity(UserSettingActivity.class);

        } else if (v.getId() == btnSetting.getId()) {
            startNewActivity(SettingActivity.class);
        }

    }

    private void startNewActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    private void loadText(TextView textView) {
        preferences = getSharedPreferences("myPrev", MODE_PRIVATE);
        String loadUserName = preferences.getString("saved_user_name", "");
        textView.setText(String.format("%s\nДобро пожаловать", loadUserName));
    }
}