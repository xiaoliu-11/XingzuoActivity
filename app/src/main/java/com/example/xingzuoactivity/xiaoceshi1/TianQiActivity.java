package com.example.xingzuoactivity.xiaoceshi1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.city_picker.CityListActivity;
import com.example.xingzuoactivity.R;
import com.example.xingzuoactivity.toastutil.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class TianQiActivity extends AppCompatActivity {
    private TextView tv;

    private  TextView tv1,tv2,tv3,tv4,tv5,tv6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tian_qi);

       ImageView btn = (ImageView) findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.name);
        tv1 = (TextView) findViewById(R.id.tv_wendu_show);
        tv2 = (TextView) findViewById(R.id.tv_tianqi_show);
        tv3 = (TextView) findViewById(R.id.tv_shidu_show);
        tv4 = (TextView) findViewById(R.id.tv_direct_show);
        tv5 = (TextView) findViewById(R.id.tv_power_show);
        tv6 = (TextView) findViewById(R.id.tv_aqi_show);






        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CityListActivity.startCityActivityForResult(TianQiActivity.this);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101&& resultCode ==102){
            String city = data.getStringExtra("city");
            tv.setText(city);
        }
    }

    //获取api

    public  void  btn_TianqiStart(View v){
        String city = tv.getText().toString();

            String url ="http://apis.juhe.cn/simpleWeather/query?city="+city+"&key=f165da074755398951de824e115812b2";

            //定义一个请求队列
            RequestQueue requestQueue = Volley.newRequestQueue(TianQiActivity.this);
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

    public  void getJson(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject result = jsonObject.getJSONObject("result");
            JSONObject realtime = result.getJSONObject("realtime");
            String temperature = realtime.getString("temperature");
            String info = realtime.getString("info");
            String humidity = realtime.getString("humidity");
            String direct = realtime.getString("direct");
            String power = realtime.getString("power");
            String aqi = realtime.getString("aqi");

            tv1.setText(temperature);
            tv2.setText(info);
            tv3.setText(humidity);
            tv4.setText(direct);
            tv5.setText(power);
            tv6.setText(aqi);
            ToastUtil.ShowMsg(TianQiActivity.this,"查询成功");

//            tv_QQ.setText(conclusion);
//            tv_qq2.setText(analysis);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }




}
