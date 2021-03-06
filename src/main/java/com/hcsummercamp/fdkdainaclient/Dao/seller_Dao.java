package com.hcsummercamp.fdkdainaclient.Dao;

import com.hcsummercamp.fdkdainaclient.Entity.POJO.Seller;
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
    public List<Seller> getSeller() throws SQLException {
        return db.select().from(SELLER).where(SELLER.STATUS.eq(UByte.valueOf(1))).fetchInto(Seller.class);
    }

    public void insertSeller(Seller seller) throws SQLException{
        SellerRecord sellerRecord = db.newRecord(SELLER);
        sellerRecord.from(seller);
        sellerRecord.setCreated(new Timestamp(System.currentTimeMillis()));
        sellerRecord.setModified(new Timestamp(System.currentTimeMillis()));
        sellerRecord.insert();
    }

    public void deleteSeller(ULong id) throws SQLException{     //设置status为0即删除
        db.update(SELLER).set(SELLER.STATUS,UByte.valueOf(0)).where(SELLER.ID.eq(id)).execute();
    }

    public boolean SellerExist(ULong merchantId){
        List<Integer> t = db.selectCount().from(SELLER).where(SELLER.PLATFORM_IDENTITY.eq(merchantId)).fetchInto(Integer.class);
     //   System.out.println(t);
        return t.get(0) > 0;
    }

    public Seller getInfo(Long sellerId){
        return db.select().from(SELLER).where(SELLER.PLATFORM_IDENTITY.eq(ULong.valueOf(sellerId)))
                .fetchInto(Seller.class).get(0);
    }
}
