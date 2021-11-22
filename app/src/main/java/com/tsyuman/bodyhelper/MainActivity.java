package com.tsyuman.bodyhelper;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.id_tv_userName_mainActivity)
    TextView txUserName;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);             // Butter Knife start

        // прем текста от предыдущего активити через Интент с помощью getStringExtra
//        Intent intent = getIntent(); // Получаем интент со стартового активити в котором есть передаваемый текст
//        String userName = intent.getStringExtra("userName"); // получаем имя пользователя по ключу.

        loadText(txUserName);
    }

    private void loadText(TextView textView) {
        preferences = getSharedPreferences("myPrev", MODE_PRIVATE);
        String loadUserName = preferences.getString("saved_user_name", "");
        textView.setText(String.format("%s\nДобро пожаловать", loadUserName));
    }
}