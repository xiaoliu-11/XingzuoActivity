package com.example.xingzuoactivity;

import android.app.Application;

import cn.smssdk.SMSSDK;

public class MobApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SMSSDK.initSDK(this, "3182bc446733b", "50bbfe550cbd642dd9fc46465440731f");
    }
}
