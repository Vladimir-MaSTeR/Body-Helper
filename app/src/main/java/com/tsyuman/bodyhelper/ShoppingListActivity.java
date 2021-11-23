package com.tsyuman.bodyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingListActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.id_btn_back_shoppingListActivity)
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        ButterKnife.bind(this);

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