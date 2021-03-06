package com.hcsummercamp.fdkdainaclient.Dao;

import com.hcsummercamp.fdkdainaclient.Entity.POJO.PlatformSpu;
import com.hcsummercamp.fdkdainaclient.db.tables.records.PlatformSpuRecord;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static com.hcsummercamp.fdkdainaclient.db.tables.PlatformSpu.PLATFORM_SPU;

@Repository
public class platform_spu_Dao extends BasicDao{
    public void insertPlatSpu(PlatformSpu platformSpu) {
        try{
            PlatformSpuRecord platformSpuRecord = db.newRecord(PLATFORM_SPU);
            platformSpuRecord.from(platformSpu);
            platformSpuRecord.setCreated(new Timestamp(System.currentTimeMillis()));
            platformSpuRecord.setModified(new Timestamp(System.currentTimeMillis()));
            platformSpuRecord.insert();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean SpuExist(Long BizId, String SpuGoodsNo){
        List<Integer> t = db.selectCount().from(PLATFORM_SPU)
                .where(PLATFORM_SPU.BIZ_ID.eq(BizId)
                        .and(PLATFORM_SPU.SPU_GOODS_NO.eq(SpuGoodsNo))).fetchInto(Integer.class);
        return t.get(0) > 0;
    }

    public String getUrl(Long BizId, String SpuGoodsNo){
        List<String> t = db.select(PLATFORM_SPU.MAIN_IMG_URL).from(PLATFORM_SPU)
                .where(PLATFORM_SPU.BIZ_ID.eq(BizId)
                        .and(PLATFORM_SPU.SPU_GOODS_NO.eq(SpuGoodsNo))).fetchInto(String.class);
        return t.get(0);
    }

    public String getUrl(String SpuGoodsNo){
        List<String> t = db.select(PLATFORM_SPU.MAIN_IMG_URL).from(PLATFORM_SPU)
                .where(PLATFORM_SPU.SPU_GOODS_NO.eq(SpuGoodsNo)).fetchInto(String.class);
        return t.get(0);
    }

    public List<PlatformSpu> getPlatformSpu(Long BizId){
        return db.select().from(PLATFORM_SPU).where(PLATFORM_SPU.BIZ_ID.eq(BizId)).fetchInto(PlatformSpu.class);
    }
}
