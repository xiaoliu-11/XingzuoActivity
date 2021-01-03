package com.example.xingzuoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xingzuoactivity.sqliteutil.DBOpenHelper;
import com.example.xingzuoactivity.style3.Style3Activity;
import com.example.xingzuoactivity.toastutil.ToastUtil;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

private EditText et1,et2;
private Button  btn1;
    private DBOpenHelper mDBOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        mDBOpenHelper = new DBOpenHelper(this);
    }


    public void initView(){

        et1=findViewById(R.id.login_reg_user);
        et2 = findViewById(R.id.login_reg_pass);
        btn1 = findViewById(R.id.login_btn_reg);
        btn1.setOnClickListener(this);
    }


    public void onClick(View view) {
        switch (view.getId()) {
           /* case R.id.iv_registeractivity_back: //返回登录页面
                Intent intent1 = new Intent(this, loginActivity.class);
                startActivity(intent1);
                finish();
                break;*/
          /*  case R.id.iv_registeractivity_showCode:    //改变随机验证码的生成
                mIvRegisteractivityShowcode.setImageBitmap(Code.getInstance().createBitmap());
                realCode = Code.getInstance().getCode().toLowerCase();
                break;*/
            case R.id.login_btn_reg:    //注册按钮
                //获取用户输入的用户名、密码、验证码
                String username = et1.getText().toString().trim();
                String password = et2.getText().toString().trim();

                //注册验证
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                  if(true){
                        mDBOpenHelper.add(username, password);

                      Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                      intent.putExtra("data_tag1","注册成功");
                      startActivity(intent);

                        finish();

                    } else {

                    }
                }else {
                    Toast.makeText(this, "未完善信息，注册失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }







}
