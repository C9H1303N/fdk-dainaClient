package com.hcsummercamp.fdkdainaclient.Entity.SupplierList;

import java.math.BigDecimal;

public class MerchantDetail {  // 销售商及数量信息
    long merchantId;
    String sellerName;
    String sellerShortName;
    int totalKind;
    BigDecimal totalNum;

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public String toString() {
        return "MerchantDetail{" +
                "merchantId=" + merchantId +
                ", sellerName='" + sellerName + '\'' +
                ", sellerShortName='" + sellerShortName + '\'' +
                ", totalKind=" + totalKind +
                ", totalNum=" + totalNum +
                '}';
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerShortName() {
        return sellerShortName;
    }

    public void setSellerShortName(String sellerShortName) {
        this.sellerShortName = sellerShortName;
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
