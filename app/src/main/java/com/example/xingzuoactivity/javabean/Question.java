package com.example.xingzuoactivity.javabean;

import cn.bmob.v3.BmobObject;

public class Question extends BmobObject {
    private int id;
    private String question;
    private String selecta;
    private String selectb;
    private String selectc;
    private String selectd;
    private String resulta;
    private String resultb;
    private String resultc;
    private String resultd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSelecta() {
        return selecta;
    }

    public void setSelecta(String selecta) {
        this.selecta = selecta;
    }

    public String getSelectb() {
        return selectb;
    }

    public void setSelectb(String selectb) {
        this.selectb = selectb;
    }

    public String getSelectc() {
        return selectc;
    }

    public void setSelectc(String selectc) {
        this.selectc = selectc;
    }

    public String getSelectd() {
        return selectd;
    }

    public void setSelectd(String selectd) {
        this.selectd = selectd;
    }

    public String getResulta() {
        return resulta;
    }

    public void setResulta(String resulta) {
        this.resulta = resulta;
    }

    public String getResultb() {
        return resultb;
    }

    public void setResultb(String resultb) {
        this.resultb = resultb;
    }

    public String getResultc() {
        return resultc;
    }

    public void setResultc(String resultc) {
        this.resultc = resultc;
    }

    public String getResultd() {
        return resultd;
    }

    public void setResultd(String resultd) {
        this.resultd = resultd;
    }
}
