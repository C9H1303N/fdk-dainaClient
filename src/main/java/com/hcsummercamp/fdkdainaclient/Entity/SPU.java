package com.hcsummercamp.fdkdainaclient.Entity;

import com.hcsummercamp.fdkdainaclient.Entity.SKU;

import java.util.ArrayList;

public class SPU {
    String mainImgUrl;      //图片
    ArrayList<SKU> skuList;
    String spuGoodsNo;      //货号
    long spuId;
    String spuName;

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    @Override
    public String toString() {
        return "SPU{" +
                "mainImgUrl='" + mainImgUrl + '\'' +
                ", skuList=" + skuList +
                ", spuGoodsNo='" + spuGoodsNo + '\'' +
                ", spuId=" + spuId +
                ", spuName='" + spuName + '\'' +
                '}';
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

    public String getSpuGoodsNo() {
        return spuGoodsNo;
    }

    public void setSpuGoodsNo(String spuGoodsNo) {
        this.spuGoodsNo = spuGoodsNo;
    }

    public long getSpuId() {
        return spuId;
    }

    public void setSpuId(long spuId) {
        this.spuId = spuId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }
}
