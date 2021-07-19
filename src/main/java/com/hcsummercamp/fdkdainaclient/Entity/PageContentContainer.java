package com.hcsummercamp.fdkdainaclient.Entity;

import java.util.ArrayList;

public class PageContentContainer<T> {
    ArrayList<T> list;
    int total;

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
