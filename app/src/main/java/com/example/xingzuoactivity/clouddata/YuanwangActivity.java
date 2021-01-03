package com.example.xingzuoactivity.clouddata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.xingzuoactivity.R;
import com.example.xingzuoactivity.javabean.Yuanwang;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class YuanwangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuanwang);
        Bmob.initialize(this, "4c8257aa102af13a00ffd654bcaa4b39");


        Yuanwang yuanwang = new Yuanwang();
        yuanwang.setContext("测试数据测试数据！");
        yuanwang.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if(e==null){
                    //Toast.makeText(QuestionActivity.this,"创建成功",Toast.LENGTH_SHORT).show();
                    toast("添加数据成功，返回objectId为："+objectId);
                }else{
                    //   Toast.makeText(QuestionActivity.this,"创建失败",Toast.LENGTH_SHORT).show();
                    toast("创建数据失败：" + e.getMessage());
                }
            }
        });

    }
    private void toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
