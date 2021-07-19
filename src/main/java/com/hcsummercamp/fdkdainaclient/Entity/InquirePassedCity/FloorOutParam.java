package com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity;

public class FloorOutParam {
    long floorCode;
    String floorName;
    long marketCode;    //市场ID

    @Override
    public String toString() {
        return "FloorOutParam{" +
                "floorCode=" + floorCode +
                ", floorName='" + floorName + '\'' +
                ", marketCode=" + marketCode +
                '}';
    }

    public long getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(long floorCode) {
        this.floorCode = floorCode;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public long getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(long marketCode) {
        this.marketCode = marketCode;
    }
}
