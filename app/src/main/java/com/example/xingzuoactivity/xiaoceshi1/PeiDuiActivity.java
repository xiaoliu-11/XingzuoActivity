package com.example.xingzuoactivity.xiaoceshi1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


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

import java.util.ArrayList;
import java.util.List;

public class PeiDuiActivity extends AppCompatActivity {


    private Spinner spinner, spinner2;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter , arr_adapter2;
    private TextView tv , tv2;
    private String str,str1;

    private TextView tv3,tv4,tv5,tv6,tv7,tv8,tv9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pei_dui);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2= (Spinner) findViewById(R.id.spinner2);

        tv = (TextView) findViewById(R.id.txt01);
        tv2 = (TextView) findViewById(R.id.txt02);

        tv3 = (TextView) findViewById(R.id.tv_zhishu_show);
        tv4 = (TextView) findViewById(R.id.tv_bizhong_show);
        tv5 = (TextView) findViewById(R.id.tv_xiangyue_show);
        tv6 = (TextView) findViewById(R.id.tv_tcdj_show);
        tv7 = (TextView) findViewById(R.id.tv_jieguo_show);
        tv8 = (TextView) findViewById(R.id.tv_lianai_show);
        tv9 = (TextView) findViewById(R.id.tv_zhuyi_show);


        str = (String) spinner.getSelectedItem();
        str1 = (String) spinner2.getSelectedItem();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                //拿到被选择项的值
                str = (String) spinner.getSelectedItem();
                //把该值传给 TextView
                tv.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                //拿到被选择项的值
                str1 = (String) spinner2.getSelectedItem();
                //把该值传给 TextView
                tv2.setText(str1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });




        //数据
        data_list = new ArrayList<String>();
        data_list.add("白羊");
        data_list.add("金牛");
        data_list.add("双子");
        data_list.add("巨蟹");
        data_list.add("狮子");
        data_list.add("处女");
        data_list.add("天秤");
        data_list.add("天蝎");
        data_list.add("射手");
        data_list.add("摩羯");
        data_list.add("水瓶");
        data_list.add("双鱼");
        //适配器
        arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);


        //适配器
        arr_adapter2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        //设置样式
        arr_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(arr_adapter);


    }



    public void btn_Peidui(View v){

        String men = tv.getText().toString();
        String women = tv2.getText().toString();

        String url ="http://apis.juhe.cn/xzpd/query?men="+men+"&women="+women+"&key=cdc8693ee56d1313830a58bd1aa662b0";
        //定义一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(PeiDuiActivity.this);
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
            String zhishu = result.getString("zhishu");
            String bizhong = result.getString("bizhong");
            String xiangyue = result.getString("xiangyue");
            String tcdj = result.getString("tcdj");
            String jieguo = result.getString("jieguo");
            String lianai = result.getString("lianai");
            String zhuyi = result.getString("zhuyi");

            // tv2.setText(yangli+yinli+wuxing+chongsha+baiji+jishen+yi+ji+xiongshen);

            tv3.setText(zhishu);
            tv4.setText(bizhong);
            tv5.setText(xiangyue);
            tv6.setText(tcdj);
            tv7.setText(jieguo);
            tv8.setText(lianai);
            tv9.setText(zhuyi);
            ToastUtil.ShowMsg(PeiDuiActivity.this,"查询成功");


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}
