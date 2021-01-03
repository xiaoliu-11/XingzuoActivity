package com.example.xingzuoactivity.xiaoceshi1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xingzuoactivity.MainActivity;
import com.example.xingzuoactivity.R;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.xingzuoactivity.toastutil.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;




public class QqTestActivity extends AppCompatActivity {

    private TextView tv_QQ , tv_qq2;
    private EditText ed_QQ;
    /*
         AppKey：28f6b0c0fbe2ef7de988650f2fa5d7d8
         请求示例：http://japi.juhe.cn/qqevaluate/qq?key=您申请的appKey&qq=295424589
       */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qq_test);
        inintView();

    }
    private void inintView() {
        tv_QQ= (TextView) findViewById(R.id.tv_showQQ);
        ed_QQ= (EditText) findViewById(R.id.et_QQ);
        tv_qq2 = (TextView) findViewById(R.id.tv_showQQ2);
    }

    public  void  btn_QQStart(View v){
        String QQ = ed_QQ.getText().toString();

        if( TextUtils.isEmpty(QQ)){
            Toast.makeText(QqTestActivity.this,"输入不能为空！",Toast.LENGTH_LONG).show();
        }else {
            String url ="http://japi.juhe.cn/qqevaluate/qq?key=d07ce1159cda7b007fa58582914b7094&qq="+QQ;

            //定义一个请求队列
            RequestQueue requestQueue = Volley.newRequestQueue(QqTestActivity.this);
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
            JSONObject data = result.getJSONObject("data");
            String conclusion = data.getString("conclusion");
            String analysis = data.getString("analysis");
            tv_QQ.setText(conclusion);
            tv_qq2.setText(analysis);
            ToastUtil.ShowMsg(QqTestActivity.this,"查询成功");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
