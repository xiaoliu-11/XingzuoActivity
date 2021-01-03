package com.example.xingzuoactivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.xingzuoactivity.R;
import com.example.xingzuoactivity.javabean.Yuanwang;

import java.util.List;

public class YuanwangAdapte extends ArrayAdapter<Yuanwang> {

    private int resourceId;
    public YuanwangAdapte(Context context, int resource, List<Yuanwang> objects) {
        super(context, resource,objects);
        resourceId =resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Yuanwang yuanwang = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView textView1 = view.findViewById(R.id.textView1);
        textView1.setText(yuanwang.getContext());
        return view;
    }




}
