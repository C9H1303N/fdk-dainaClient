package com.hcsummercamp.fdkdainaclient.Entity.GettingGoods;

import com.hcsummercamp.fdkdainaclient.Entity.SPU;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ProgressingSKU {       //待拿、拿中、已拿未结、代退、退中 sku
    String bizFullName;     //档口全称
    long bizId;     // 档口 id
    BigDecimal moneyAmount;
    ArrayList<SPU> spuList;
    int totalKind;      //种类
    BigDecimal totalNum;   //数量

    public String getBizFullName() {
        return bizFullName;
    }

    @Override
    public String toString() {
        return "ProgressingSKU{" +
                "bizFullName='" + bizFullName + '\'' +
                ", bizId=" + bizId +
                ", moneyAmount=" + moneyAmount +
                ", spuList=" + spuList +
                ", totalKind=" + totalKind +
                ", totalNum=" + totalNum +
                '}';
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

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
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

    public BigDecimal getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(BigDecimal totalNum) {
        this.totalNum = totalNum;
    }
}
