package com.example.xingzuoactivity.fragment;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.xingzuoactivity.R;
import com.example.xingzuoactivity.toastutil.ToastUtil;
import com.example.xingzuoactivity.xiaoceshi1.ChengyuActivity;
import com.example.xingzuoactivity.xiaoceshi1.ErWeiActivity;
import com.example.xingzuoactivity.xiaoceshi1.PeiDuiActivity;
import com.example.xingzuoactivity.xiaoceshi1.QqTestActivity;
import com.example.xingzuoactivity.xiaoceshi1.RiliActivity;
import com.example.xingzuoactivity.xiaoceshi1.ShengxiaoActivity;
import com.example.xingzuoactivity.xiaoceshi1.TianQiActivity;
import com.example.xingzuoactivity.xiaoceshi1.XiaoHuaActivity;

public class TwoFragment extends Fragment {
    SimpleAdapter simpleAdapter;
    private ImageView image1,image2,image3,image4;
    private ImageView image5,image6,image7,image8;

    public TwoFragment() {
        // Required empty public constructor
    }



    public static TwoFragment newInstance() {
        TwoFragment fragment = new TwoFragment();
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {






        View view =inflater.inflate(R.layout.fragment_two,container,false);
        image1 = view.findViewById(R.id.test_qq);
        image2 = view.findViewById(R.id.test_rili);
        image3 = view.findViewById(R.id.test_tianqi);
        image4 = view.findViewById(R.id.test_peidui);
        image5 = view.findViewById(R.id.test_xiaohua);
        image6 = view.findViewById(R.id.test_erweima);
        image7 = view.findViewById(R.id.test_chengyu);
        image8 = view.findViewById(R.id.test_shengxiao);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  ToastUtil.ShowMsg(getActivity(),"点击了qq");
                Intent intent = new Intent(getActivity(), QqTestActivity.class);
                startActivity(intent);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ToastUtil.ShowMsg(getActivity(),"点击了qq");
                Intent intent = new Intent(getActivity(), RiliActivity.class);
                startActivity(intent);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   ToastUtil.ShowMsg(getActivity(),"点击了qq");
                Intent intent = new Intent(getActivity(), TianQiActivity.class);
                startActivity(intent);
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  ToastUtil.ShowMsg(getActivity(),"点击了qq");
                Intent intent = new Intent(getActivity(), PeiDuiActivity.class);
                startActivity(intent);
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ToastUtil.ShowMsg(getActivity(),"点击了qq");
                Intent intent = new Intent(getActivity(), XiaoHuaActivity.class);
                startActivity(intent);
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ToastUtil.ShowMsg(getActivity(),"点击了qq");
                Intent intent = new Intent(getActivity(), ErWeiActivity.class);
                startActivity(intent);
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ToastUtil.ShowMsg(getActivity(),"点击了qq");
                Intent intent = new Intent(getActivity(), ChengyuActivity.class);
                startActivity(intent);
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ToastUtil.ShowMsg(getActivity(),"点击了qq");
                Intent intent = new Intent(getActivity(), ShengxiaoActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}



