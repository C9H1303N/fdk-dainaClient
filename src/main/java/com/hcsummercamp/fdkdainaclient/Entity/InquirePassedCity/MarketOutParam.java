package com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity;

import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.FloorOutParam;

import java.util.ArrayList;

public class MarketOutParam {
    long cityCode;
    ArrayList<FloorOutParam> floorList;
    long marketCode;
    long marketId;
    String marketName;

    public long getCityCode() {
        return cityCode;
    }

    public void setCityCode(long cityCode) {
        this.cityCode = cityCode;
    }

    public ArrayList<FloorOutParam> getFloorList() {
        return floorList;
    }

    public void setFloorList(ArrayList<FloorOutParam> floorList) {
        this.floorList = floorList;
    }

    public long getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(long marketCode) {
        this.marketCode = marketCode;
    }

    public long getMarketId() {
        return marketId;
    }

    public void setMarketId(long marketId) {
        this.marketId = marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
}
