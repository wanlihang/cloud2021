package com.wlh.springcloud.entity;

public class Pianke {
    private String piankeStu; //姓名
    private String piankeSub; // 科目

    public Pianke(String piankeStu, String piankeSub) {
        this.piankeStu = piankeStu;
        this.piankeSub = piankeSub;
    }

    public String getPiankeStu() {
        return piankeStu;
    }

    public void setPiankeStu(String piankeStu) {
        this.piankeStu = piankeStu;
    }

    public String getPiankeSub() {
        return piankeSub;
    }

    public void setPiankeSub(String piankeSub) {
        this.piankeSub = piankeSub;
    }
}
