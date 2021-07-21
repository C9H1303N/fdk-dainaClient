package com.hcsummercamp.fdkdainaclient.Dao;

import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerFetchOrder;
import com.hcsummercamp.fdkdainaclient.db.tables.records.SellerFetchOrderRecord;
import org.jooq.types.UByte;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static com.hcsummercamp.fdkdainaclient.db.tables.SellerFetchOrder.SELLER_FETCH_ORDER;
import static org.jooq.types.UByte.valueOf;

@Repository
public class seller_fetch_order_Dao extends BasicDao{
    public void insertSellerFetchOrder(SellerFetchOrder SellerFetchOrder) throws SQLException {
        SellerFetchOrderRecord sellerFetchOrderRecord = db.newRecord(SELLER_FETCH_ORDER);
        sellerFetchOrderRecord.from(SellerFetchOrder);
        sellerFetchOrderRecord.setCreated(new Timestamp(System.currentTimeMillis()));
        sellerFetchOrderRecord.setModified(new Timestamp(System.currentTimeMillis()));
        sellerFetchOrderRecord.insert();
    }

    public boolean SellerFetchOrderExist(Long merchantId, String SellerOrderId){
        List<Integer> t = db.selectCount().from(SELLER_FETCH_ORDER)
                .where(SELLER_FETCH_ORDER.MERCHANT_ID.eq(merchantId)
                        .and(SELLER_FETCH_ORDER.SELLER_ORDER_ID.eq(SellerOrderId))).fetchInto(Integer.class);
        return t.get(0) > 0;
    }

    public void printTag(List<Long> id) throws SQLException{
        db.update(SELLER_FETCH_ORDER).set(SELLER_FETCH_ORDER.TAG_PRINT_FLAG,(byte) 1)
                .set(SELLER_FETCH_ORDER.STATUS,(byte)2).where(SELLER_FETCH_ORDER.ID.in(id)).execute();
    }
}
