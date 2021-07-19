package com.hcsummercamp.fdkdainaclient.Entity.GettingGoods;

public class SKU {
    int availableNum; //可退数量
    long skuId;
    String skuName;
    int toReturnNum;       //待退数量

    public int getAvailableNum() {
        return availableNum;
    }

    public void setAvailableNum(int availableNum) {
        this.availableNum = availableNum;
    }

    public long getSkuId() {
        return skuId;
    }

    public void setSkuId(long skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public int getToReturnNum() {
        return toReturnNum;
    }

    public void setToReturnNum(int toReturnNum) {
        this.toReturnNum = toReturnNum;
    }
}
