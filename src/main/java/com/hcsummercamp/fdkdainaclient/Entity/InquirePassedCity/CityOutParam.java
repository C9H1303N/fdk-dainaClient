package com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity;

import java.util.List;

public class CityOutParam {
    long cityCode;      //城市编码
    long cityId;        //城市ID
    String cityName;        //城市名称
    List<MarketOutParam> marketList;       //市场列表

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

    public List<MarketOutParam> getMarketList() {
        return marketList;
    }

    public void setMarketList(List<MarketOutParam> marketList) {
        this.marketList = marketList;
    }
}
