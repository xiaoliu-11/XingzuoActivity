package com.example.xingzuoactivity.toastutil;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static Toast toast;
    public static void ShowMsg(Context context , String msg){
        if(toast == null){
            toast = Toast.makeText(context,msg,Toast.LENGTH_LONG);

        }else{
            toast.setText(msg);
        }
        toast.show();
    }

}
