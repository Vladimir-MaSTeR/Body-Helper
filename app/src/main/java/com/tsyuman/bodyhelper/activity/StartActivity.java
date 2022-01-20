package com.tsyuman.bodyhelper.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tsyuman.bodyhelper.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG_IN_LOG = "MyLogs";
    private static final String PREFIX_MESSAGE_IN_LOG = "StartActivity:";


    @BindView(R.id.id_et_tapName_startActivity)
    EditText edTextName;

    @BindView(R.id.id_btn_go_startActivity)
    Button btnGo;

    SharedPreferences preferences;

    private static final String SAVED_USER_NAME = "saved_user_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG_IN_LOG, String.format("-----%s метод onCreate - начал работу", PREFIX_MESSAGE_IN_LOG ));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ButterKnife.bind(this);             // Butter Knife start
        Log.d(TAG_IN_LOG, String.format("%s ButterKnife отработал", PREFIX_MESSAGE_IN_LOG ));

        btnGo.setOnClickListener(this);
        Log.d(TAG_IN_LOG, String.format("%s слушатель присвоен кнопке", PREFIX_MESSAGE_IN_LOG));

        loadText();
        Log.d(TAG_IN_LOG, String.format("-----%s метод onCreate - работу закончил", PREFIX_MESSAGE_IN_LOG ));
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG_IN_LOG, String.format("-----%s метод onClick - начал работу", PREFIX_MESSAGE_IN_LOG));

        if (v.getId() == btnGo.getId()
                && !edTextName.getText().toString().trim().isEmpty()) {

            Intent intent = new Intent(this, MainActivity.class);
            saveText();
            startActivity(intent);

            Log.d(TAG_IN_LOG, String.format("%s запущена MainActivity", PREFIX_MESSAGE_IN_LOG));
        } else {
            Log.d(TAG_IN_LOG, String.format("%s Пользователь воодит имя", PREFIX_MESSAGE_IN_LOG));
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
        Log.d(TAG_IN_LOG, String.format("-----%s метод onClick - работу закончил", PREFIX_MESSAGE_IN_LOG ));
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG_IN_LOG, String.format("-----%s метод onDestroy - начал работу", PREFIX_MESSAGE_IN_LOG ));

        super.onDestroy();
        saveText();

        Log.d(TAG_IN_LOG, String.format("-----%s метод onDestroy - работу закончил", PREFIX_MESSAGE_IN_LOG ));
    }

    private void saveText() {
        Log.d(TAG_IN_LOG, String.format("-----%s метод saveText - начал работу", PREFIX_MESSAGE_IN_LOG ));

        preferences = getSharedPreferences("myPrev", MODE_PRIVATE); // первое значение имя папки куда сохранять
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SAVED_USER_NAME, edTextName.getText().toString());
        editor.commit(); // сохраняем данные

        Log.d(TAG_IN_LOG, String.format("%s Имя - \\\" %s\\\" сохранено в памяти телефона",
                PREFIX_MESSAGE_IN_LOG,
                edTextName.getText().toString()));

        Log.d(TAG_IN_LOG, String.format("-----%s метод saveText - работу закончил", PREFIX_MESSAGE_IN_LOG ));
    }

    private void loadText() {
        Log.d(TAG_IN_LOG, String.format("-----%s метод loadText - начал работу", PREFIX_MESSAGE_IN_LOG ));

        preferences = getSharedPreferences("myPrev", MODE_PRIVATE);
        String savedText = preferences.getString(SAVED_USER_NAME, "");
        edTextName.setText(savedText);

        Log.d(TAG_IN_LOG, String.format("%s Текст - \\\"%s\\\" загружен из памяти телефона",
                PREFIX_MESSAGE_IN_LOG,
                savedText));

        Log.d(TAG_IN_LOG, String.format("-----%s метод loadText - работу закончил", PREFIX_MESSAGE_IN_LOG ));
    }

}