package com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity;

import java.util.ArrayList;

public class CityOutParam {
    long cityCode;      //城市编码
    long cityId;        //城市ID
    String cityName;        //城市名称
    ArrayList<MarketOutParam> marketList;       //市场列表

    public long getCityCode() {
        return cityCode;
    }

    @Override
    public String toString() {
        return "CityOutParam{" +
                "cityCode=" + cityCode +
                ", cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", marketList=" + marketList +
                '}';
    }

    public void setCityCode(long cityCode) {
        this.cityCode = cityCode;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public ArrayList<MarketOutParam> getMarketList() {
        return marketList;
    }

    public void setMarketList(ArrayList<MarketOutParam> marketList) {
        this.marketList = marketList;
    }
}
