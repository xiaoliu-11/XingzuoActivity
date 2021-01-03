package com.example.xingzuoactivity.clouddata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.xingzuoactivity.R;
import com.example.xingzuoactivity.javabean.Question;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Bmob.initialize(this, "4c8257aa102af13a00ffd654bcaa4b39");
        //第二种方法失败，不知到原因！

        //插入数据
        Question question = new Question();
        question.setQuestion("这是代码插入的问题1");
        question.setSelecta("选项a");
        question.setSelectb("选项b");
        question.setSelectc("选项c");
        question.setSelectd("选项d");
        question.setResulta("选项a的答案");
        question.setResultb("选项b的答案");
        question.setResultc("选项c的答案");
        question.setResultd("选项d的答案");
        question.save(new SaveListener<String>() {
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


        //查找Question表里面id为6b6c11c537的数据
   /*     BmobQuery<Question> bmobQuery = new BmobQuery<Question>();
        bmobQuery.getObject("fb21921920", new QueryListener<Question>() {
            @Override
            public void done(Question object,BmobException e) {
                if(e==null){
                    toast("查询成功");
                }else{
                    toast("查询失败：" + e.getMessage());
                }
            }
        });*/


    }
    private void toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
