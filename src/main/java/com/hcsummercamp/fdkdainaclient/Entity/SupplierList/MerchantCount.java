package com.hcsummercamp.fdkdainaclient.Entity.SupplierList;

public class MerchantCount {// 拿货销商数量统计汇总
    String bizFullName;     //档口全称，精准搜索
    long cityId;
    long floorId;
    long marketId;
    String spuGoodsNo;      //货号，模糊搜索
    int status;     //状态：@1待拿 @2拿中 @3已拿未结 @11待退 @12退中

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
