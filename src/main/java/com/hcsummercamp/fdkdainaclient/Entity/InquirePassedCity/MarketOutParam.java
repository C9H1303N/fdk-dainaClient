package com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity;

import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.FloorOutParam;

import java.util.ArrayList;

public class MarketOutParam {
    long cityCode;      //城市编码
    ArrayList<FloorOutParam> floorList;     //楼层列表
    long marketCode;        //市场编码
    long marketId;
    String marketName;

    @Override
    public String toString() {
        return "MarketOutParam{" +
                "cityCode=" + cityCode +
                ", floorList=" + floorList +
                ", marketCode=" + marketCode +
                ", marketId=" + marketId +
                ", marketName='" + marketName + '\'' +
                '}';
    }

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
