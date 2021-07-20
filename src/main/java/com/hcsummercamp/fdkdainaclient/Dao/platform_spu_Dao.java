package com.hcsummercamp.fdkdainaclient.Dao;

import com.hcsummercamp.fdkdainaclient.Entity.POJO.PlatformSpu;
import com.hcsummercamp.fdkdainaclient.db.tables.records.PlatformSpuRecord;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

import static com.hcsummercamp.fdkdainaclient.db.tables.PlatformSpu.PLATFORM_SPU;

@Repository
public class platform_spu_Dao extends BasicDao{
    public void insertPlatSpu(PlatformSpu platformSpu){
        PlatformSpuRecord platformSpuRecord = db.newRecord(PLATFORM_SPU);
        platformSpuRecord.from(platformSpu);
        platformSpuRecord.setCreated(new Timestamp(System.currentTimeMillis()));
        platformSpuRecord.setModified(new Timestamp(System.currentTimeMillis()));
        platformSpuRecord.insert();
    }

    public boolean SpuExist(Long BizId, String SpuGoodsNo){
        List<Integer> t = db.selectCount().from(PLATFORM_SPU)
                .where(PLATFORM_SPU.BIZ_ID.eq(BizId)
                        .and(PLATFORM_SPU.SPU_GOODS_NO.eq(SpuGoodsNo))).fetchInto(Integer.class);
        return t.get(0) > 0;
    }

}
