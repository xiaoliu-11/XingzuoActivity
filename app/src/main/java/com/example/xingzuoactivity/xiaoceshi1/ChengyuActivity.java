package com.example.xingzuoactivity.xiaoceshi1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.xingzuoactivity.R;
import com.example.xingzuoactivity.toastutil.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class ChengyuActivity extends AppCompatActivity {

    private TextView tv1 , tv2;
    private EditText ed_chengyu;

    private TextView tv3,tv4,tv5,tv6,tv7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chengyu);
        inintView();
    }

    private void inintView() {
        ed_chengyu = (EditText) findViewById(R.id.et_chengyu);
        tv3 = (TextView) findViewById(R.id.tv_show_chengyu_pinyin);
        tv4 = (TextView) findViewById(R.id.tv_jieshi_test_show);
        tv5 = (TextView) findViewById(R.id.tv_laiyuan_test_show);
        tv6 = (TextView) findViewById(R.id.tv_yufa_test_show);
        tv7 = (TextView) findViewById(R.id.tv_yinzhengjs_show);

    }
    public  void  btn_ChengyuStart(View v){
        String chengyu = ed_chengyu.getText().toString();
        if( TextUtils.isEmpty(chengyu)){
            Toast.makeText(ChengyuActivity.this,"输入不能为空！",Toast.LENGTH_LONG).show();
        }else {
            String url ="http://v.juhe.cn/chengyu/query?word="+chengyu+"&dtype=&key=b0e57b04b784d36b501e7d1c8c591a6a";
            //定义一个请求队列
            RequestQueue requestQueue = Volley.newRequestQueue(ChengyuActivity.this);
            //请求一个事件
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    getJson(s);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {

                }
            });
            //添加事件到队列
            requestQueue.add(stringRequest);
        }}
    public  void getJson(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject result = jsonObject.getJSONObject("result");
            String pinyin = result.getString("pinyin");
            String jieshi = result.getString("chengyujs");
            String laiyuan = result.getString("from_");
            String yufa = result.getString("yufa");
            String yinzhengjs = result.getString("yinzhengjs");
            tv3.setText(pinyin);
            tv4.setText(jieshi);
            tv5.setText(laiyuan);
            tv6.setText(yufa);
            tv7.setText(yinzhengjs);
            ToastUtil.ShowMsg(ChengyuActivity.this,"查询成功");
        } catch (JSONException e) {
            e.printStackTrace();
            ToastUtil.ShowMsg(ChengyuActivity.this,"查询失败");
        }

    }
}
