package com.hcsummercamp.fdkdainaclient.Dao;

import com.hcsummercamp.fdkdainaclient.Entity.POJO.platform_sku;
import com.hcsummercamp.fdkdainaclient.db.tables.records.PlatformSkuRecord;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

import static com.hcsummercamp.fdkdainaclient.db.tables.PlatformSku.PLATFORM_SKU;

@Repository
public class platform_sku_Dao extends BasicDao{
    public void insertPlatSku(platform_sku platform_sku){
        PlatformSkuRecord platformSkuRecord = db.newRecord(PLATFORM_SKU);
        platformSkuRecord.from(platform_sku);
        platformSkuRecord.setCreated(new Timestamp(System.currentTimeMillis()));
        platformSkuRecord.setModified(new Timestamp(System.currentTimeMillis()));
        platformSkuRecord.insert();
    }
}
