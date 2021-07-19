package com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity;

import java.util.ArrayList;

public class CityOutParam {
    long cityCode;
    long cityId;
    String cityName;
    ArrayList<MarketOutParam> marketList;

    public long getCityCode() {
        return cityCode;
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
