package com.hcsummercamp.fdkdainaclient.Dao;

import com.hcsummercamp.fdkdainaclient.Entity.POJO.PlatformSku;
import com.hcsummercamp.fdkdainaclient.db.tables.records.PlatformSkuRecord;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Timestamp;

import static com.hcsummercamp.fdkdainaclient.db.tables.PlatformSku.PLATFORM_SKU;

@Repository
public class platform_sku_Dao extends BasicDao{
    public void insertPlatSku(PlatformSku PlatformSku) {
        try{
            PlatformSkuRecord platformSkuRecord = db.newRecord(PLATFORM_SKU);
            platformSkuRecord.from(PlatformSku);
            platformSkuRecord.setCreated(new Timestamp(System.currentTimeMillis()));
            platformSkuRecord.setModified(new Timestamp(System.currentTimeMillis()));
            platformSkuRecord.insert();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
