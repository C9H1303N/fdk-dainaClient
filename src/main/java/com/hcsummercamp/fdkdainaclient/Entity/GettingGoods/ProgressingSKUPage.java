package com.hcsummercamp.fdkdainaclient.Entity.GettingGoods;

import java.util.ArrayList;

public class ProgressingSKUPage {      //待拿、拿中、已拿未结、代退、退中 sku 分页
    String bizFullName;     //档口全称，精准搜索
    long cityId;
    long floorId;
    long marketId;
    long merchantId;
    int order;      //顺序：@1正序，@2倒序，默认按正序
    int pageIndex;
    int pageSize;
    ArrayList<SKU> skuIdList;       //过滤 sku id
    int sort;       //排序方式：@1货号，默认不传
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

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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

    public ArrayList<SKU> getSkuIdList() {
        return skuIdList;
    }

    public void setSkuIdList(ArrayList<SKU> skuIdList) {
        this.skuIdList = skuIdList;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
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

