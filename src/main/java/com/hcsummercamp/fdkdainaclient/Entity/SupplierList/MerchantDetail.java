package com.hcsummercamp.fdkdainaclient.Entity.SupplierList;

public class MerchantDetail {  // 销售商及数量信息
    long merchantId;
    String sellerName;
    String sellerShortName;
    int totalKind;
    int totalNum;

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
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

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
}
