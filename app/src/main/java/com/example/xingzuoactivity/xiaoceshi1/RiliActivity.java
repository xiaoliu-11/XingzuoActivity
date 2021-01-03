package com.example.xingzuoactivity.xiaoceshi1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
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

import java.text.SimpleDateFormat;
import java.util.Date;

public class RiliActivity extends AppCompatActivity {
    private ImageView btn;
    private TextView tv, tv2;
    private TextView tv3,tv4,tv5,tv6,tv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rili);

       btn=(ImageView)this.findViewById(R.id.btn_xiugai);
        tv= (TextView) this.findViewById(R.id.tv_rili);

        tv3= (TextView) this.findViewById(R.id.tv_yinli_show);
        tv4= (TextView) this.findViewById(R.id.tv_yi_show);
        tv5= (TextView) this.findViewById(R.id.tv_ji_show);
        tv6= (TextView) this.findViewById(R.id.tv_baiji_show);
        tv7= (TextView) this.findViewById(R.id.tv_chongsha_show);


        //下面三行代码，获取系统当前日期

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
//获取当前时间
        Date date = new Date(System.currentTimeMillis());
        tv.setText(simpleDateFormat.format(date));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(RiliActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tv.setText(String.format("%d-%d-%d",year,monthOfYear+1,dayOfMonth));
                    }
                },2000,1,2).show();
            }

        });

    }

    public void btn_RiliDate(View v){

      String date = tv.getText().toString();

        String url ="http://v.juhe.cn/laohuangli/d?date="+date+"&key=6e7bdfbeafdcfc92848f4616b73a54be";
        //定义一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(RiliActivity.this);
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
            String yangli = result.getString("yangli");
            String yinli = result.getString("yinli");
            String wuxing = result.getString("wuxing");
            String chongsha = result.getString("chongsha");
            String baiji = result.getString("baiji");
            String jishen = result.getString("jishen");
            String yi = result.getString("yi");
            String ji = result.getString("ji");
            String xiongshen = result.getString("xiongshen");

           // tv2.setText(yangli+yinli+wuxing+chongsha+baiji+jishen+yi+ji+xiongshen);

            tv3.setText(yinli);
            tv4.setText(yi);
            tv5.setText(ji);
            tv6.setText(baiji);
            tv7.setText(chongsha);
            ToastUtil.ShowMsg(RiliActivity.this,"查询成功");


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}
