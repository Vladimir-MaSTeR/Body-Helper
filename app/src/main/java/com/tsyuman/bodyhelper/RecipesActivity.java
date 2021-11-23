package com.tsyuman.bodyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.id_btn_back_recipesActivity)
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);             // Butter Knife start

        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnBack.getId()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
}