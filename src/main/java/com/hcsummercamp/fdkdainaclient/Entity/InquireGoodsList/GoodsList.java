package com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList;

import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.SKU;

import java.util.ArrayList;

public class GoodsList {
    String bizFullName; //档口全称
    String mainImgUrl; //图片
    ArrayList<SKU> skuList;
    int spuFetchNum;//SPU 拿货数量
    int spuGoodsNo; // 货号
    long spuId;
    int spuReturnNum; //SPU 退货数量

    public String getBizFullName() {
        return bizFullName;
    }

    public void setBizFullName(String bizFullName) {
        this.bizFullName = bizFullName;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }

    public ArrayList<SKU> getSkuList() {
        return skuList;
    }

    public void setSkuList(ArrayList<SKU> skuList) {
        this.skuList = skuList;
    }

    public int getSpuFetchNum() {
        return spuFetchNum;
    }

    public void setSpuFetchNum(int spuFetchNum) {
        this.spuFetchNum = spuFetchNum;
    }

    public int getSpuGoodsNo() {
        return spuGoodsNo;
    }

    public void setSpuGoodsNo(int spuGoodsNo) {
        this.spuGoodsNo = spuGoodsNo;
    }

    public long getSpuId() {
        return spuId;
    }

    public void setSpuId(long spuId) {
        this.spuId = spuId;
    }

    public int getSpuReturnNum() {
        return spuReturnNum;
    }

    public void setSpuReturnNum(int spuReturnNum) {
        this.spuReturnNum = spuReturnNum;
    }
}
