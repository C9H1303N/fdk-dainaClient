package com.hcsummercamp.fdkdainaclient.Entity;

import java.math.BigDecimal;

public class SKU {
    BigDecimal availableNum; //可退数量
    long skuId;
    String skuName;
    BigDecimal toReturnNum;       //待退数量

    public void setAvailableNum(BigDecimal availableNum) {
        this.availableNum = availableNum;
    }

    public void setToReturnNum(BigDecimal toReturnNum) {
        this.toReturnNum = toReturnNum;
    }

    public BigDecimal getAvailableNum() {
        return availableNum;
    }

    public BigDecimal getToReturnNum() {
        return toReturnNum;
    }

    @Override
    public String toString() {
        return "SKU{" +
                "availableNum=" + availableNum +
                ", skuId=" + skuId +
                ", skuName='" + skuName + '\'' +
                ", toReturnNum=" + toReturnNum +
                '}';
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

}
