package com.hcsummercamp.fdkdainaclient.Dao;

import com.hcsummercamp.fdkdainaclient.Entity.POJO.seller_fetch_order;
import com.hcsummercamp.fdkdainaclient.db.tables.records.SellerFetchOrderRecord;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

import static com.hcsummercamp.fdkdainaclient.db.tables.SellerFetchOrder.SELLER_FETCH_ORDER;

@Repository
public class seller_fetch_order_Dao extends BasicDao{
    public void insertSellerFetchOrder(seller_fetch_order seller_fetch_order){
        SellerFetchOrderRecord sellerFetchOrderRecord = db.newRecord(SELLER_FETCH_ORDER);
        sellerFetchOrderRecord.from(seller_fetch_order);
        sellerFetchOrderRecord.setCreated(new Timestamp(System.currentTimeMillis()));
        sellerFetchOrderRecord.setModified(new Timestamp(System.currentTimeMillis()));
        sellerFetchOrderRecord.insert();
    }
}
