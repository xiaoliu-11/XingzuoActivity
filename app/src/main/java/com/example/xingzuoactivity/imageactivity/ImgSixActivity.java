package com.example.xingzuoactivity.imageactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.xingzuoactivity.R;
import com.example.xingzuoactivity.imagedownload.DonwloadSaveImg;

public class ImgSixActivity extends AppCompatActivity {


    private ImageView image1;
    private static final int REQUEST_CODE_SAVE_IMG = 10;
    private static final String TAG = "ImgOneActivity";
    private Context mContext;
    //
    private Bitmap bitmap;
    private String Path="http://81.68.179.52:8080/master/images/sheshouzuo.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_six);
        image1 = findViewById(R.id.iamge_bizhisix);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DonwloadSaveImg.donwloadImg(ImgSixActivity.this,Path);

            }
        });

    }
}
