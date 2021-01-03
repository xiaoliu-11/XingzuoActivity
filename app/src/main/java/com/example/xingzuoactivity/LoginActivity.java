package com.example.xingzuoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xingzuoactivity.sqliteutil.DBOpenHelper;
import com.example.xingzuoactivity.sqliteutil.User;
import com.example.xingzuoactivity.style3.Style3Activity;
import com.example.xingzuoactivity.toastutil.ToastUtil;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText et1,et2;
    private Button btn1;
    private TextView btn2;
    private String name, pass;
    public static final String Name = "Name";
    public static final String Pass = "Pass";
    private DBOpenHelper mDBOpenHelper;
    private TextView phone_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complex_activity_main);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("data_tag1");
      //  ToastUtil.ShowMsg(LoginActivity.this,msg);


        phone_1 = findViewById(R.id.phone_1);
        et1 = (EditText)findViewById(R.id.login_input_username);
        et2 =(EditText) findViewById(R.id.login_input_password);
        /*获取Shared Preferences对象*/
        SharedPreferences setinfo = getPreferences(Activity.MODE_PRIVATE);
        //把值传给两个文本框
        name = setinfo.getString(Name,"");
        pass = setinfo.getString(Pass,"");
        et1.setText(name);
        et2.setText(pass);
        //创建一个DBhelper对象
        mDBOpenHelper = new DBOpenHelper(this);
        //初始化控件
        initView();
        //点击事件

       btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String name = et1.getText().toString().trim();
               String password = et2.getText().toString().trim();
               if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                   ArrayList<User> data = mDBOpenHelper.getAllData();
                   boolean match = false;
                   for (int i = 0; i < data.size(); i++) {
                       User user = data.get(i);
                       if (name.equals(user.getName()) && password.equals(user.getPassword())) {
                           match = true;
                           break;
                       } else {
                           match = false;
                       }
                   }
                   if (match) {

                       Intent intent = new Intent(LoginActivity.this,Style3Activity.class);
                       intent.putExtra("data_tag","登录成功");
                       startActivity(intent);
                       finish();//销毁此Activity
                   } else {
                       ToastUtil.ShowMsg(getApplicationContext(),"用户名或密码错误");
                   }
               } else {
                   ToastUtil.ShowMsg(getApplicationContext(),"请输入用户名或密码");
               }

    }
});
        //点击事件
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);

                startActivity(intent);
            }
        });



        //点击事件,手机快捷登录
        phone_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, PhoneActivity.class);

                startActivity(intent);
            }
        });
    }




  //初始化控件的方法
    public void initView(){
        btn1 = findViewById(R.id.login_btn);
        btn2 = findViewById(R.id.login_register);
    }


    //停止shareprefereceed的方法
    @Override
    protected void onStop() {
        SharedPreferences setinfo = getPreferences(Activity.MODE_PRIVATE);
        setinfo.edit()
                .putString(Name, et1.getText().toString())
                .putString(Pass, et2.getText().toString())
                .commit();
        super.onStop();
    }








}
