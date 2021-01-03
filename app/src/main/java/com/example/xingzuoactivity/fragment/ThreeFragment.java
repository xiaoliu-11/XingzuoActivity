package com.example.xingzuoactivity.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.xingzuoactivity.Adapter.YuanwangAdapte;
import com.example.xingzuoactivity.R;
import com.example.xingzuoactivity.javabean.Yuanwang;
import com.example.xingzuoactivity.toastutil.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class ThreeFragment extends Fragment {

    private ImageView btn1;
    ListView listView;
    public ThreeFragment() {
        // Required empty public constructor
    }


    public static ThreeFragment newInstance() {
        ThreeFragment fragment = new ThreeFragment();
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_three,container,false);

        //给listview添加长按弹出上下文菜单。
        listView = view.findViewById(R.id.listView_cloud);
        this.registerForContextMenu(listView);




         //（初始化）注册云数据库
        Bmob.initialize(getContext(), "4c8257aa102af13a00ffd654bcaa4b39");
        btn1 = view.findViewById(R.id.add_yuanwang);
        Yuanwang yuanwang = new Yuanwang();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"asdf",Toast.LENGTH_SHORT).show();
             /*   yuanwang.setContext("狂吃不胖！");
                yuanwang.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId, BmobException e) {
                        if(e==null){
                            Toast.makeText(getActivity(),"创建成功",Toast.LENGTH_SHORT).show();

                        }else{
                              Toast.makeText(getActivity(),"创建失败",Toast.LENGTH_SHORT).show();

                        }
                    }
                });*/

                AlertDialog.Builder  builder4 = new AlertDialog.Builder(getActivity());
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_alert,null);
                EditText text_yuanwang = view.findViewById(R.id.text_yuanwang);
                Button btn = view.findViewById(R.id.btn_cloud_add);
                btn.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        String yuanwangneirong = text_yuanwang.getText().toString();
                        if(TextUtils.isEmpty(yuanwangneirong) ){
                            ToastUtil.ShowMsg(getActivity(), "请输入你的愿望哦");
                        }else {

                            yuanwang.setContext(yuanwangneirong);
                            yuanwang.save(new SaveListener<String>() {
                                @Override
                                public void done(String objectId, BmobException e) {
                                    if (e == null) {
                                        ToastUtil.ShowMsg(getActivity(), "愿望添加成功！加油哟！");

                                    } else {
                                        ToastUtil.ShowMsg(getActivity(), "愿望添加失败，请重试");

                                    }
                                }
                            });

                        }

                    }
                });

                builder4.setTitle("请添加您的愿望:").setView(view).show();
            }
        });

        //     从Bmob查找数据，在ListView显示
        BmobQuery<Yuanwang> bmobQuery = new BmobQuery<Yuanwang>();
        bmobQuery.findObjects(new FindListener<Yuanwang>() {
            @Override
            public void done(List<Yuanwang> list, BmobException e) {
                if(e==null){
                    Log.d("path","查询成功");
                    YuanwangAdapte personAdapte = new YuanwangAdapte(getActivity(),R.layout.clouddata,list);
                     listView = view.findViewById(R.id.listView_cloud);
                    listView.setAdapter(personAdapte);
                }
                else{
                    Log.d("path","查询不成功");
                }
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("选项");
        menu.add(0,0, Menu.NONE,"删除");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 0 :
                //btn3.setText(item.getTitle().toString());



                ToastUtil.ShowMsg(getActivity(),"删除成功");
                break;

        }
        return  true;
    }
}
