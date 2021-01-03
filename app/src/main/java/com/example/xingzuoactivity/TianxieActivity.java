package com.example.xingzuoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.xingzuoactivity.toastutil.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class TianxieActivity extends AppCompatActivity {
    private TextView tv1,tv2,tv3,tv4,tv5,tv6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tianxie);


        tv1 = (TextView) findViewById(R.id.tv_friend_test_show_tx);
        tv2 = (TextView) findViewById(R.id.tv_yanse_test_show_tx);
        tv3 = (TextView) findViewById(R.id.tv_health_test_show_tx);
        tv4 = (TextView) findViewById(R.id.tv_love_test_show_tx);
        tv5 = (TextView) findViewById(R.id.tv_number_test_show_tx);
        tv6 = (TextView) findViewById(R.id.tv_summary_test_show_tx);

    }

    public  void  btn_TianxieTodayStart(View v){

        String url ="http://web.juhe.cn:8080/constellation/getAll?consName=天蝎座&type=today&key=1f1307646312de0317b089c8f0eaa003";

        //定义一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(TianxieActivity.this);
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
    }


    //////////本周

    public  void  btn_TianxieWeeksStart(View v){

        String url1 ="http://web.juhe.cn:8080/constellation/getAll?consName=天蝎座&type=week&key=1f1307646312de0317b089c8f0eaa003";

        //定义一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(TianxieActivity.this);
        //请求一个事件
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                getJsonWeek(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        //添加事件到队列
        requestQueue.add(stringRequest);
    }




    public  void getJson(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            String QFriend = jsonObject.getString("QFriend");
            String color = jsonObject.getString("color");
            String health = jsonObject.getString("health");
            String love = jsonObject.getString("love");
            String number = jsonObject.getString("number");
            String summary = jsonObject.getString("summary");

//            tv_QQ.setText(conclusion);
//            tv_qq2.setText(analysis);
            tv1.setText(QFriend);
            tv2.setText(color);
            tv3.setText(health);
            tv4.setText(love);
            tv5.setText(number);
            tv6.setText(summary);
            ToastUtil.ShowMsg(TianxieActivity.this,"查询成功");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }










/////////////////////////////////////本周

    public  void getJsonWeek(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            String weekth = jsonObject.getString("weekth");
            String date = jsonObject.getString("date");
            String job = jsonObject.getString("job");
            String love = jsonObject.getString("love");
            String money = jsonObject.getString("money");
            String work = jsonObject.getString("work");
//            tv_QQ.setText(conclusion);
//            tv_qq2.setText(analysis);

            tv1.setText(weekth);
            tv2.setText(date);
            tv3.setText(job);
            tv4.setText(love);
            tv5.setText(money);
            tv6.setText(work);




            ToastUtil.ShowMsg(TianxieActivity.this,"查询成功");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
