package com.hcsummercamp.fdkdainaclient.Entity.DownloadGoodsList;

import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.SKU;

import java.util.ArrayList;

public class GettingGoodsList {        //下载拿、退货单
    String bizFullName; //档口全称，精准搜索
    long cityId;
    long floorId;
    long marketId;
    long merchantId;
    boolean selectAll;  //是否跨页全选；全选需要传范围，否则需要传 skuIdList
    ArrayList<SKU> skuIdList;
    String spuGoodsNo;      //货号，模糊搜索

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

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }

    public boolean isSelectAll() {
        return selectAll;
    }

    public void setSelectAll(boolean selectAll) {
        this.selectAll = selectAll;
    }

    public ArrayList<SKU> getSkuIdList() {
        return skuIdList;
    }

    public void setSkuIdList(ArrayList<SKU> skuIdList) {
        this.skuIdList = skuIdList;
    }

    public String getSpuGoodsNo() {
        return spuGoodsNo;
    }

    public void setSpuGoodsNo(String spuGoodsNo) {
        this.spuGoodsNo = spuGoodsNo;
    }
}
