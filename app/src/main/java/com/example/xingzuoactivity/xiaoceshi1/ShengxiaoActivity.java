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

public class ShengxiaoActivity extends AppCompatActivity {

    private Spinner spinner, spinner2;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter , arr_adapter2;
    private TextView tv , tv2;
    private String str,str1;

    private TextView tv3,tv4,tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shengxiao);

        spinner = (Spinner) findViewById(R.id.spinner_shengxiao);
        spinner2= (Spinner) findViewById(R.id.spinner2_shengxiao);

        tv = (TextView) findViewById(R.id.txt01_shengxiao);
        tv2 = (TextView) findViewById(R.id.txt02_shengxiao);

        tv3 = (TextView) findViewById(R.id.tv_men_show);
        tv4 = (TextView) findViewById(R.id.tv_women_show);
        tv5 = (TextView) findViewById(R.id.tv_shengxiao_show);


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
        data_list.add("鼠");
        data_list.add("牛");
        data_list.add("虎");
        data_list.add("兔");
        data_list.add("龙");
        data_list.add("蛇");
        data_list.add("马");
        data_list.add("羊");
        data_list.add("猴");
        data_list.add("鸡");
        data_list.add("狗");
        data_list.add("猪");
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



    public void btn_Shengxiao(View v){

        String men = tv.getText().toString();
        String women = tv2.getText().toString();

        String url ="http://apis.juhe.cn/sxpd/query?men="+men+"&women="+women+"&key=f2cf11f8660820e778032b80a0403e15";
        //定义一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(ShengxiaoActivity.this);
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
            String men = result.getString("men");
            String woemn = result.getString("women");
            String data = result.getString("data");

            tv3.setText(men);
            tv4.setText(woemn);
            tv5.setText(data);

            ToastUtil.ShowMsg(ShengxiaoActivity.this,"查询成功");


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
