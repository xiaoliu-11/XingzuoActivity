package com.example.xingzuoactivity.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.xingzuoactivity.R;
import com.example.xingzuoactivity.SignActivity;
import com.example.xingzuoactivity.toastutil.ToastUtil;

public class NetworkChangedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int netWorkStates = NetworkUtil.getNetWorkStates(context);

        switch (netWorkStates) {
            case NetworkUtil.TYPE_NONE:
                //断网了
                System.out.println("断网了");
               Toast.makeText(context,"数据连接已关闭",Toast.LENGTH_LONG).show();
                break;
            case NetworkUtil.TYPE_MOBILE:
                //打开了移动网络
                System.out.println("打开了移动网络");
                Toast.makeText(context,"打开了移动网络",Toast.LENGTH_LONG).show();
                break;
            case NetworkUtil.TYPE_WIFI:
                //打开了WIFI
                System.out.println("打开了WIFI");
                Toast.makeText(context,"断网了",Toast.LENGTH_LONG).show();
                break;

            default:
                break;
        }
    }

}
