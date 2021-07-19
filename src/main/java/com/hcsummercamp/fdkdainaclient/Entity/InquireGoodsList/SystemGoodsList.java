package com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList;

public class SystemGoodsList {      //系统货品列表
    String bizFullName; //档口全称，精准搜索
    long cityId;
    long floorId;
    long marketId;
    int pageIndex;
    int pageSize;
    String spuGoodsNo; //货号，模糊搜索

    public String getBizFullName() {
        return bizFullName;
    }

    public void setBizFullName(String bizFullName) {
        this.bizFullName = bizFullName;
    }

    public long getCityId() {
        return cityId;
    }

    @Override
    public String toString() {
        return "SystemGoodsList{" +
                "bizFullName='" + bizFullName + '\'' +
                ", cityId=" + cityId +
                ", floorId=" + floorId +
                ", marketId=" + marketId +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", spuGoodsNo='" + spuGoodsNo + '\'' +
                '}';
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

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpuGoodsNo() {
        return spuGoodsNo;
    }

    public void setSpuGoodsNo(String spuGoodsNo) {
        this.spuGoodsNo = spuGoodsNo;
    }
}
