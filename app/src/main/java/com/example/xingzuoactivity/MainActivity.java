package com.example.xingzuoactivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


import com.example.xingzuoactivity.style3.Style3Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button mBtnStyle3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        mBtnStyle3 = findViewById(R.id.style3_btn);

        mBtnStyle3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.style3_btn:
                startActivity(new Intent(MainActivity.this, Style3Activity.class));
                break;
            default:
                break;
        }
    }
}
