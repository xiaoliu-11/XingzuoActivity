package com.example.xingzuoactivity.javabean;

import cn.bmob.v3.BmobObject;

public class Yuanwang extends BmobObject {

    private int id;
    private String context;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

}
