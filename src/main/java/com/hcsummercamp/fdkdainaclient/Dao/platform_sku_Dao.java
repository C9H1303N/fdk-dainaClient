package com.hcsummercamp.fdkdainaclient.Dao;

import com.hcsummercamp.fdkdainaclient.Entity.POJO.PlatformSku;
import com.hcsummercamp.fdkdainaclient.Entity.SKU;
import com.hcsummercamp.fdkdainaclient.db.tables.records.PlatformSkuRecord;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

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

    public List<SKU> getSKU(Long bizId){
        return db.selectDistinct(PLATFORM_SKU.ID.as("skuId"),PLATFORM_SKU.SKU_NAME).from(PLATFORM_SKU)
                .where(PLATFORM_SKU.BIZ_ID.eq(bizId)).fetchInto(SKU.class);
    }


    public List<SKU> getSKUs(Long spuId){
        return db.selectDistinct(PLATFORM_SKU.ID.as("skuId"),PLATFORM_SKU.SKU_NAME).from(PLATFORM_SKU)
                .where(PLATFORM_SKU.SPU_ID.eq(spuId)).fetchInto(SKU.class);
    }

    public int getCountSKU(Long spuId){
        return db.selectCount().from(PLATFORM_SKU).where(PLATFORM_SKU.SPU_ID.eq(spuId)).fetchInto(Integer.class).get(0);
    }
}
