package com.hcsummercamp.fdkdainaclient.Entity.GettingGoods;

import java.util.ArrayList;

public class ProgressingSKU {       //待拿、拿中、已拿未结、代退、退中 sku
    String bizFullName;     //档口全称
    long bizId;     // 档口 id
    int moneyAmount;
    ArrayList<SPU> spuList;
    int totalKind;      //种类
    int totalNum;   //数量

    public String getBizFullName() {
        return bizFullName;
    }

    public void setBizFullName(String bizFullName) {
        this.bizFullName = bizFullName;
    }

    public long getBizId() {
        return bizId;
    }

    public void setBizId(long bizId) {
        this.bizId = bizId;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public ArrayList<SPU> getSpuList() {
        return spuList;
    }

    public void setSpuList(ArrayList<SPU> spuList) {
        this.spuList = spuList;
    }

    public int getTotalKind() {
        return totalKind;
    }

    public void setTotalKind(int totalKind) {
        this.totalKind = totalKind;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
}
