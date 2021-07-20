package com.hcsummercamp.fdkdainaclient.Dao;

import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerFetchOrder;
import com.hcsummercamp.fdkdainaclient.db.tables.records.SellerFetchOrderRecord;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

import static com.hcsummercamp.fdkdainaclient.db.tables.SellerFetchOrder.SELLER_FETCH_ORDER;

@Repository
public class seller_fetch_order_Dao extends BasicDao{
    public void insertSellerFetchOrder(SellerFetchOrder SellerFetchOrder){
        SellerFetchOrderRecord sellerFetchOrderRecord = db.newRecord(SELLER_FETCH_ORDER);
        sellerFetchOrderRecord.from(SellerFetchOrder);
        sellerFetchOrderRecord.setCreated(new Timestamp(System.currentTimeMillis()));
        sellerFetchOrderRecord.setModified(new Timestamp(System.currentTimeMillis()));
        sellerFetchOrderRecord.insert();
    }

    public boolean SellerFetchOrderExist(Long merchantId, Long BizId, Long SkuId){
        List<Integer> t = db.selectCount().from(SELLER_FETCH_ORDER)
                .where(SELLER_FETCH_ORDER.MERCHANT_ID.eq(merchantId)
                        .and(SELLER_FETCH_ORDER.BIZ_ID.eq(BizId)
                                .and(SELLER_FETCH_ORDER.PLATFORM_SKU_ID.eq(SkuId)))).fetchInto(Integer.class);
        return t.get(0) > 0;
    }
}
