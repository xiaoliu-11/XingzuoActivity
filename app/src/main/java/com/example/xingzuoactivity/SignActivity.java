package com.example.xingzuoactivity;


import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xingzuoactivity.imageactivity.ImgEightActivity;
import com.example.xingzuoactivity.imageactivity.ImgElevenActivity;
import com.example.xingzuoactivity.imageactivity.ImgFiveActivity;
import com.example.xingzuoactivity.imageactivity.ImgFourActivity;
import com.example.xingzuoactivity.imageactivity.ImgNineActivity;
import com.example.xingzuoactivity.imageactivity.ImgOneActivity;
import com.example.xingzuoactivity.imageactivity.ImgSevenActivity;
import com.example.xingzuoactivity.imageactivity.ImgSixActivity;
import com.example.xingzuoactivity.imageactivity.ImgTenActivity;
import com.example.xingzuoactivity.imageactivity.ImgThreeActivity;
import com.example.xingzuoactivity.imageactivity.ImgTweleveActivity;
import com.example.xingzuoactivity.imageactivity.ImgTwoActivity;


public class SignActivity extends AppCompatActivity {

    private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        img1 = findViewById(R.id.img1tupian);
        img2 = findViewById(R.id.img2tupian);
        img3 = findViewById(R.id.img3tupian);
        img4 = findViewById(R.id.img4tupian);
        img5 = findViewById(R.id.img5tupian);
        img6 = findViewById(R.id.img6tupian);
        img7 = findViewById(R.id.img7tupian);
        img8 = findViewById(R.id.img8tupian);
        img9 = findViewById(R.id.img9tupian);
        img10 = findViewById(R.id.img10tupian);
        img11= findViewById(R.id.img11tupian);
        img12 = findViewById(R.id.img12tupian);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this, ImgOneActivity.class);
                startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this, ImgTwoActivity.class);
                startActivity(intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this, ImgThreeActivity.class);
                startActivity(intent);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this, ImgFourActivity.class);
                startActivity(intent);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this, ImgFiveActivity.class);
                startActivity(intent);
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this, ImgSixActivity.class);
                startActivity(intent);
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this, ImgSevenActivity.class);
                startActivity(intent);
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this, ImgEightActivity.class);
                startActivity(intent);
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this, ImgNineActivity.class);
                startActivity(intent);
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this, ImgTenActivity.class);
                startActivity(intent);
            }
        });
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this, ImgElevenActivity.class);
                startActivity(intent);
            }
        });

        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this, ImgTweleveActivity.class);
                startActivity(intent);
            }
        });






    }



}
