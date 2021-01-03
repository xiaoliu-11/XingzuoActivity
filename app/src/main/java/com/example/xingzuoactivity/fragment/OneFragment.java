package com.example.xingzuoactivity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.xingzuoactivity.BaiyangActivity;
import com.example.xingzuoactivity.ChunvActivity;
import com.example.xingzuoactivity.JinniuActivity;
import com.example.xingzuoactivity.JuxieActivity;
import com.example.xingzuoactivity.MojieActivity;
import com.example.xingzuoactivity.R;
import com.example.xingzuoactivity.SheshouActivity;
import com.example.xingzuoactivity.ShiziActivity;
import com.example.xingzuoactivity.ShuangyuActivity;
import com.example.xingzuoactivity.ShuangziActivity;
import com.example.xingzuoactivity.ShuipingActivity;
import com.example.xingzuoactivity.TianpingActivity;
import com.example.xingzuoactivity.TianxieActivity;
import com.example.xingzuoactivity.imagelunbo.Image3DSwitchView;
import com.example.xingzuoactivity.toastutil.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneFragment  extends Fragment implements AdapterView.OnItemClickListener {
        ListView listView;
        SimpleAdapter simpleAdapter;
    private Image3DSwitchView imageSwitchView;


    public OneFragment() {
        // Required empty public constructor
    }

    public static OneFragment newInstance() {
        OneFragment fragment = new OneFragment();
        return fragment;
    }


    /**
 *   布局文件和framagement 关联
 * @param inflater
 * @param container
 * @param savedInstanceState
 * @return
 */
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_one,container,false);
        listView =view.findViewById(R.id.my_list);
        simpleAdapter = new SimpleAdapter(getActivity(),getData(),R.layout.imagelist,new String[]{"title","image"},new int[]{R.id.myMenu_name,R.id.myMenu_image});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
        return view;
        }

private List<Map<String,Object>> getData() {
        String [] titles={"白羊座(3.21-4.19)","处女座(8.23-9.22)","金牛座(4.20-5.20)","巨蟹座(6.22-7.22)","魔羯座(12.22-1.19)","射手座(11.23-12.21)","狮子座(7.23-8.22)","双鱼座(2.19-3.20)","双子座(5.21-6.21)","水平座(1.20-2.18)","天平座(9.23-10.23)","天蝎座(10.24-11.22)"};
        int [] images={R.drawable.peidui_baiyang,R.drawable.peidui_chunv,R.drawable.peidui_jinniu,
        R.drawable.peidui_juxie,R.drawable.peidui_mojie,
        R.drawable.peidui_sheshou,R.drawable.peidui_shizi,
                R.drawable.peidui_shuangyu,R.drawable.peidui_shuangzi,
                R.drawable.peidui_shuiping,R.drawable.peidui_tianping,
                R.drawable.peidui_tianxie
        };
        List<Map<String,Object>> list= new ArrayList<>();
        for(int i=0;i<12;i++){
        Map  map = new HashMap();
        map.put("title",titles[i]);
        map.put("image",images[i]);
        list.add(map);
        }
        return list;
        }

@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        }



@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String text = listView.getAdapter().getItem(position).toString();
     //   L.i("position:"+position+"text"+text );
            //ToastUtil.ShowMsg(getActivity(),"点击了"+text);
      if(position == 0){
          Intent intent = new Intent(getActivity(), BaiyangActivity.class);
          startActivity(intent);
      }else if (position == 1){
          Intent intent = new Intent(getActivity(), ChunvActivity.class);
          startActivity(intent);
      }else if (position == 2){
          Intent intent = new Intent(getActivity(), JinniuActivity.class);
          startActivity(intent);
      }else if (position == 3){
          Intent intent = new Intent(getActivity(), JuxieActivity.class);
          startActivity(intent);
      }else if (position == 4){
          Intent intent = new Intent(getActivity(), MojieActivity.class);
          startActivity(intent);
      }else if (position == 5){
          Intent intent = new Intent(getActivity(), SheshouActivity.class);
          startActivity(intent);
      }else if (position == 6){
          Intent intent = new Intent(getActivity(), ShiziActivity.class);
          startActivity(intent);
      }else if (position == 7){
          Intent intent = new Intent(getActivity(), ShuangyuActivity.class);
          startActivity(intent);
      }else if (position == 8){
          Intent intent = new Intent(getActivity(), ShuangziActivity.class);
          startActivity(intent);
      }else if (position == 9){
          Intent intent = new Intent(getActivity(), ShuipingActivity.class);
          startActivity(intent);
      }else if (position == 10){
          Intent intent = new Intent(getActivity(), TianpingActivity.class);
          startActivity(intent);
      }else if (position == 11){
          Intent intent = new Intent(getActivity(), TianxieActivity.class);
          startActivity(intent);
      }



        }


}
