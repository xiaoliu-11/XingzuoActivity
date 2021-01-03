package com.example.xingzuoactivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import com.example.xingzuoactivity.R;
import com.example.xingzuoactivity.toastutil.ToastUtil;
import com.example.xingzuoactivity.utils.nav_bar;


public class PersonFragment   extends Fragment {

    private nav_bar one,two,three,five,six;
    private Button button , button1;
    private EditText edittext;

    private TextView tv1,tv2;

    private ImageView  img_imageview;

    public PersonFragment() {
        // Required empty public constructor
    }



    public static PersonFragment newInstance() {
        PersonFragment fragment = new PersonFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_person, container, false);

        one= view.findViewById(R.id.gerenziliao);
        two = view.findViewById(R.id.shoucang);
        three = view.findViewById(R.id.version);
        five= view.findViewById(R.id.lianxi);
        six = view.findViewById(R.id.manager);
        tv1 = view.findViewById(R.id.user_yonghuming);

        tv2 = view.findViewById(R.id.user_yonghuxingzuo);
       // tv2.setText("asdfas");

        img_imageview = view.findViewById(R.id.img_imageview);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),GerenziliaoActivity.class);
                startActivity(intent);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.ShowMsg(getActivity(),"已经是最新版本");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),GuanyuActivity.class);
                startActivity(intent);
            }
        });


        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ToastUtil.ShowMsg(getActivity(),"点击了练习客服");
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 10086));
                startActivity(intent);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),ManagerActivity.class);
                startActivity(intent);
            }
        });

        img_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //头像的上传。

            }
        });

       

        return view;
    }

    //此方法用来回传用户名和星座。


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = new Intent(getContext(), GerenziliaoActivity.class);
        startActivityForResult(intent,5);
        switch (requestCode){
            case 5:
             String   searchContent = data.getExtras().getString("text");
                 tv1.setText(searchContent);
                System.out.println("--search==>"+searchContent);
                break;
        }
    }




}
