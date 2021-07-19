package com.hcsummercamp.fdkdainaclient.Dao;

import com.hcsummercamp.fdkdainaclient.Entity.seller.seller;
import org.jooq.types.ULong;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.hcsummercamp.fdkdainaclient.db.tables.Seller.SELLER;

@Repository
public class seller_Dao extends BasicDao{
    public List<seller> getseller(){
        return db.select().from(SELLER).where(SELLER.ID.eq(ULong.valueOf(1))).fetchInto(seller.class);
    }
}
