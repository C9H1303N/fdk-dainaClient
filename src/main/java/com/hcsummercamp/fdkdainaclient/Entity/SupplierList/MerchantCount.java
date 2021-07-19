package com.hcsummercamp.fdkdainaclient.Entity.SupplierList;

public class MerchantCount {// 拿货销商数量统计汇总
    String bizFullName;
    long cityId;
    long floorId;
    long marketId;
    String spuGoodsNo;
    int status;

    public String getBizFullName() {
        return bizFullName;
    }

    public void setBizFullName(String bizFullName) {
        this.bizFullName = bizFullName;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public long getFloorId() {
        return floorId;
    }

    public void setFloorId(long floorId) {
        this.floorId = floorId;
    }

    public long getMarketId() {
        return marketId;
    }

    public void setMarketId(long marketId) {
        this.marketId = marketId;
    }

    public String getSpuGoodsNo() {
        return spuGoodsNo;
    }

    public void setSpuGoodsNo(String spuGoodsNo) {
        this.spuGoodsNo = spuGoodsNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
