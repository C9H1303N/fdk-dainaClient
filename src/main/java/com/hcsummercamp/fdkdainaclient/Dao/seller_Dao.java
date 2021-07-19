package com.hcsummercamp.fdkdainaclient.Dao;

import com.hcsummercamp.fdkdainaclient.Entity.POJO.seller;
import com.hcsummercamp.fdkdainaclient.db.tables.records.SellerRecord;
import org.jooq.types.UByte;
import org.jooq.types.ULong;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static com.hcsummercamp.fdkdainaclient.db.tables.Seller.SELLER;

@Repository
public class seller_Dao extends BasicDao{
    public List<seller> getSeller() throws SQLException {
        return db.select().from(SELLER).where(SELLER.STATUS.eq(UByte.valueOf(1))).fetchInto(seller.class);
    }

    public void insertSeller(seller seller) throws SQLException{
        SellerRecord sellerRecord = db.newRecord(SELLER);
        sellerRecord.from(seller);
        sellerRecord.setCreated(new Timestamp(System.currentTimeMillis()));
        sellerRecord.setModified(new Timestamp(System.currentTimeMillis()));
        sellerRecord.insert();
    }

    public void deleteSeller(ULong id) throws SQLException{     //设置status为0即删除
        db.update(SELLER).set(SELLER.STATUS,UByte.valueOf(0)).where(SELLER.ID.eq(id)).execute();
    }
}
