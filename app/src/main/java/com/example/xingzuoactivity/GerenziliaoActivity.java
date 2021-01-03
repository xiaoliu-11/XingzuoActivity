package com.example.xingzuoactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Person;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.xingzuoactivity.toastutil.ToastUtil;
import com.example.xingzuoactivity.utils.nav_bar;
import com.example.xingzuoactivity.xiaoceshi1.RiliActivity;

import java.util.LinkedList;
import java.util.List;

public class GerenziliaoActivity extends AppCompatActivity {
    //用来传值（用户名，星座）
    private FragmentManager fragmentManager;
    private nav_bar one,two,three,four,five,six,seven ,eight,nine;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6;
       private Button button1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenziliao);
        two = findViewById(R.id.gerenyonghuming);
        three = findViewById(R.id.gerenxingbie);
        four = findViewById(R.id.gerenxingzuo);
        five = findViewById(R.id.gerenshengxiao);
        six = findViewById(R.id.gerensehgnri);
        seven = findViewById(R.id.geren_qq);
        eight = findViewById(R.id.geren_xiugaimima);
        nine = findViewById(R.id.chakanxiangqing);
        //得到的个人资料
        tv1 = findViewById(R.id.xiangqing_yonghuming);
        tv2 = findViewById(R.id.xiangqing_sex);
        tv3 = findViewById(R.id.xiangqing_xingzuo);
        tv4 = findViewById(R.id.xiangqing_shengxiao);
        tv5 = findViewById(R.id.xiangqing_shengri);
        tv6 = findViewById(R.id.xiangqing_qq);

//退出
        button1 = findViewById(R.id.geren_tuichu);

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // ToastUtil.ShowMsg(GerenziliaoActivity.this,"点击了用户名");
                AlertDialog.Builder  builder4 = new AlertDialog.Builder(GerenziliaoActivity.this);
                View view = LayoutInflater.from(GerenziliaoActivity.this).inflate(R.layout.layout_alertyonghuming,null);
                EditText text_yhm = view.findViewById(R.id.text_yhm);
                Button btn = view.findViewById(R.id.btn_yhm_add);
                btn.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        String zhi = text_yhm.getText().toString();
                        ToastUtil.ShowMsg(GerenziliaoActivity.this,"修改成功");
                    }
                });

                builder4.setTitle("输入用户名:").setView(view).show();
            }


        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String[] a = new String[]{"男","女"};
                AlertDialog.Builder  builder2 = new AlertDialog.Builder(GerenziliaoActivity.this);
                builder2.setTitle("选择性别:").setSingleChoiceItems(a, 1 ,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.ShowMsg(GerenziliaoActivity.this,a[which]);
                    }
                }).setCancelable(true).show();



            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final String[] a = new String[]{"白羊座(3.21-4.19)","处女座(8.23-9.22)","金牛座(4.20-5.20)","巨蟹座(6.22-7.22)","魔羯座(12.22-1.19)","射手座(11.23-12.21)","狮子座(7.23-8.22)","双鱼座(2.19-3.20)","双子座(5.21-6.21)","水平座(1.20-2.18)","天平座(9.23-10.23)","天蝎座(10.24-11.22)"};
                AlertDialog.Builder  builder2 = new AlertDialog.Builder(GerenziliaoActivity.this);
                builder2.setTitle("选择你的星座:").setSingleChoiceItems(a, 1 ,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.ShowMsg(GerenziliaoActivity.this,a[which]);
                    }
                }).setCancelable(true).show();









            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final String[] a = new String[]{"鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪"};
                AlertDialog.Builder  builder2 = new AlertDialog.Builder(GerenziliaoActivity.this);
                builder2.setTitle("选择你的生肖:").setSingleChoiceItems(a, 1 ,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.ShowMsg(GerenziliaoActivity.this,a[which]);
                    }
                }).setCancelable(true).show();





            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//生日选择
                new DatePickerDialog(GerenziliaoActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //   tv.setText(String.format("%d-%d-%d",year,monthOfYear+1,dayOfMonth));
                        String time1 = String.format("%d-%d-%d",year,monthOfYear+1,dayOfMonth);
                        ToastUtil.ShowMsg(GerenziliaoActivity.this,time1);

                    }
                },2000,1,2).show();

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                AlertDialog.Builder  builder4 = new AlertDialog.Builder(GerenziliaoActivity.this);
                View view = LayoutInflater.from(GerenziliaoActivity.this).inflate(R.layout.layout_alertqq,null);
                EditText text_yhm = view.findViewById(R.id.text_yhm_qq);
                Button btn = view.findViewById(R.id.btn_yhm_add_qq);
                btn.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                    }
                });

                builder4.setTitle("输入你的QQ:").setView(view).show();
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder  builder4 = new AlertDialog.Builder(GerenziliaoActivity.this);
                View view = LayoutInflater.from(GerenziliaoActivity.this).inflate(R.layout.layout_chakanxiangqing,null);



                builder4.setTitle("你的资料:").setView(view).show();
            }

        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //退出程序
             AlertDialog.Builder  builder = new AlertDialog.Builder(GerenziliaoActivity.this);
                builder.setTitle("").setMessage("确定要退出嘛？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent = new Intent(GerenziliaoActivity.this, LoginActivity.class);

                                startActivity(intent);

                            }
                        }).setNegativeButton("再逛逛", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.ShowMsg(GerenziliaoActivity.this,"那就去逛逛吧");
                    }
                }).show();

            }
        });


    }
}
