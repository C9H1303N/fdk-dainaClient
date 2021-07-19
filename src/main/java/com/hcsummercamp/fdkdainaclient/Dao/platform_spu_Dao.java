package com.hcsummercamp.fdkdainaclient.Dao;

import com.hcsummercamp.fdkdainaclient.Entity.POJO.platform_spu;
import com.hcsummercamp.fdkdainaclient.db.tables.records.PlatformSpuRecord;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

import static com.hcsummercamp.fdkdainaclient.db.tables.PlatformSpu.PLATFORM_SPU;

@Repository
public class platform_spu_Dao extends BasicDao{
    public void insertPlatSpu(platform_spu platform_spu){
        PlatformSpuRecord platformSpuRecord = db.newRecord(PLATFORM_SPU);
        platformSpuRecord.from(platform_spu);
        platformSpuRecord.setCreated(new Timestamp(System.currentTimeMillis()));
        platformSpuRecord.setModified(new Timestamp(System.currentTimeMillis()));
        platformSpuRecord.insert();
    }
}
