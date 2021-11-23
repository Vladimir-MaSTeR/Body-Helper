package com.tsyuman.bodyhelper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.id_et_tapName_startActivity)
    EditText edTextName;

    @BindView(R.id.id_btn_go_startActivity)
    Button btnGo;

    SharedPreferences preferences;

    private static final String SAVED_USER_NAME = "saved_user_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);             // Butter Knife start

        btnGo.setOnClickListener(this);

        loadText();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnGo.getId()
                && !edTextName.getText().toString().trim().isEmpty()) {

            Intent intent = new Intent(this, MainActivity.class);
            saveText();
            startActivity(intent);

        } else {
            Toast.makeText(StartActivity.this, "Нужно ввести имя", Toast.LENGTH_SHORT).show();
        }


        // Вариант передачи текста другому активити через Интент с помощью getStringExtra
//        switch (v.getId()) {
//            case R.id.id_btn_go_startActivity:
//                Intent intent = new Intent(this, MainActivity.class);
//                intent.putExtra("userName", edTextName.getText().toString()); // передаем набранный текст другому активити
//                saveText();
//                startActivity(intent);
//                break;
//
//            default:
//                break;
//        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

    private void saveText() {
        preferences = getSharedPreferences("myPrev", MODE_PRIVATE); // первое значение имя папки куда сохранять
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SAVED_USER_NAME, edTextName.getText().toString());
        editor.commit(); // сохраняем данные
    }

    private void loadText() {
        preferences = getSharedPreferences("myPrev", MODE_PRIVATE);
        String savedText = preferences.getString(SAVED_USER_NAME, "");
        edTextName.setText(savedText);
    }

}