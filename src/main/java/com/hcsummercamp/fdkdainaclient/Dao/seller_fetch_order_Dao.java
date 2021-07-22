package com.hcsummercamp.fdkdainaclient.Dao;

import com.hcsummercamp.fdkdainaclient.Common.page.PageContentContainer;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKU;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKUPage;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.GoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.SystemGoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerFetchOrder;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantDetail;
import com.hcsummercamp.fdkdainaclient.Entity.Tag.TagInfo;
import com.hcsummercamp.fdkdainaclient.Entity.Tag.TagRequest;
import com.hcsummercamp.fdkdainaclient.db.tables.records.SellerFetchOrderRecord;
import org.jooq.Condition;
import org.jooq.types.ULong;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static com.hcsummercamp.fdkdainaclient.db.tables.SellerFetchOrder.SELLER_FETCH_ORDER;

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

    public SellerFetchOrder getFetchOrder(String barcode){
        return db.select().from(SELLER_FETCH_ORDER).where(SELLER_FETCH_ORDER.PLATFORM_BARCODE.eq(barcode))
                .fetchInto(SellerFetchOrder.class).get(0);
    }

    public boolean tagExist(String barcode){
        List<Integer> t = db.selectCount().from(SELLER_FETCH_ORDER)
                .where(SELLER_FETCH_ORDER.PLATFORM_BARCODE.eq(barcode)).fetchInto(Integer.class);
        return t.get(0)>0;
    }

    public boolean scanDuplicated(String barcode){
        return db.select(SELLER_FETCH_ORDER.STATUS).from(SELLER_FETCH_ORDER)
                .where(SELLER_FETCH_ORDER.PLATFORM_BARCODE.eq(barcode))
                .fetchInto(Integer.class).get(0) == 3;
    }

    public void scanTag(String barcode){
        db.update(SELLER_FETCH_ORDER).set(SELLER_FETCH_ORDER.STATUS,(byte)3)
                .set(SELLER_FETCH_ORDER.SCAN_TIME,new Timestamp(System.currentTimeMillis()))
                .where(SELLER_FETCH_ORDER.PLATFORM_BARCODE.eq(barcode))
                .execute();
    }

    public List<MerchantDetail> getMerchant(){
        List<MerchantDetail> t =  db.selectDistinct(SELLER_FETCH_ORDER.MERCHANT_ID, SELLER_FETCH_ORDER.SELLER_NAME,
                SELLER_FETCH_ORDER.SELLER_SHORT_NAME)
                .from(SELLER_FETCH_ORDER).fetchInto(MerchantDetail.class);
        for(MerchantDetail merchantDetail : t){
            merchantDetail.setTotalKind(db.selectDistinct(SELLER_FETCH_ORDER.PLATFORM_SKU_ID).from(SELLER_FETCH_ORDER)
            .where(SELLER_FETCH_ORDER.MERCHANT_ID.eq(merchantDetail.getMerchantId())).fetchInto(ULong.class).size());
            merchantDetail.setTotalNum(db.selectCount().from(SELLER_FETCH_ORDER)
                    .where(SELLER_FETCH_ORDER.MERCHANT_ID.eq(merchantDetail.getMerchantId()))
            .fetchInto(BigDecimal.class).get(0));
        }
        return t;
    }

    public List<TagInfo> getTagInfo(TagRequest tagRequest){
        Condition condition = SELLER_FETCH_ORDER.CITY_ID.eq(tagRequest.getCityId());
        if(tagRequest.getMarketId() != null && tagRequest.getMarketId()!=0){
            condition = condition.and(SELLER_FETCH_ORDER.MARKET_ID.eq(tagRequest.getMarketId()));
            if(tagRequest.getFloorId() != null && tagRequest.getFloorId()!=0){
                condition = condition.and(SELLER_FETCH_ORDER.FLOOR_CODE.eq(tagRequest.getFloorId()));
            }
        }
        if(tagRequest.getBizFullName() != null && !tagRequest.getBizFullName().equals("")){
            condition = condition.and(SELLER_FETCH_ORDER.BIZ_NAME.eq(tagRequest.getBizFullName()));
        }
        if(tagRequest.getMerchantId() != null && tagRequest.getMerchantId()!=0){
            condition = condition.and(SELLER_FETCH_ORDER.MERCHANT_ID.eq(tagRequest.getMerchantId()));
        }
        if(tagRequest.getSpuGoodsNo() != null && !tagRequest.getSpuGoodsNo().equals("")){
            condition = condition.and(SELLER_FETCH_ORDER.SPU_GOODS_NO.like(tagRequest.getSpuGoodsNo()));
        }
        if(tagRequest.getNumType() == 2){       //未打印数量
            condition = condition.and(SELLER_FETCH_ORDER.STATUS.eq((byte) 1));//未打印
        }
        if(!tagRequest.isSelectAll()){
            condition = condition.and(SELLER_FETCH_ORDER.ID.in(tagRequest.getSkuIdList()));
        }
        return db.select(SELLER_FETCH_ORDER.PLATFORM_BARCODE.as("barcode"),SELLER_FETCH_ORDER.BIZ_NAME.as("bizFullName"),
                SELLER_FETCH_ORDER.ID,SELLER_FETCH_ORDER.SELLER_SHORT_NAME,
                SELLER_FETCH_ORDER.SKU_NAME,SELLER_FETCH_ORDER.SPU_GOODS_NO)
                .from(SELLER_FETCH_ORDER).where(condition).fetchInto(TagInfo.class);
    }

    public List<ProgressingSKU> getProgressingSKU(ProgressingSKUPage progressingSKUPage){
        Condition condition = SELLER_FETCH_ORDER.CITY_ID.eq(progressingSKUPage.getCityId());
        condition = condition.and(SELLER_FETCH_ORDER.STATUS.notEqual((byte)3));
        if(progressingSKUPage.getBizFullName() != null && !progressingSKUPage.getBizFullName().equals("")){
            condition = condition.and(SELLER_FETCH_ORDER.BIZ_NAME.eq(progressingSKUPage.getBizFullName()));
        }
        if(progressingSKUPage.getFloorId() != 0){
            condition = condition.and(SELLER_FETCH_ORDER.FLOOR_CODE.eq(progressingSKUPage.getFloorId()));
        }
        if(progressingSKUPage.getMarketId() != 0){
            condition = condition.and(SELLER_FETCH_ORDER.MARKET_ID.eq(progressingSKUPage.getMarketId()));
        }
        if(progressingSKUPage.getMerchantId() != 0){
            condition = condition.and(SELLER_FETCH_ORDER.MERCHANT_ID.eq(progressingSKUPage.getMerchantId()));
        }
        if(progressingSKUPage.getSkuIdList() != null){
            condition = condition.and(SELLER_FETCH_ORDER.PLATFORM_SKU_ID.in(progressingSKUPage.getSkuIdList()));
        }
        if(progressingSKUPage.getSpuGoodsNo() != null && !progressingSKUPage.getSpuGoodsNo().equals("")){
            condition = condition.and(SELLER_FETCH_ORDER.SPU_GOODS_NO.like(progressingSKUPage.getSpuGoodsNo()));
        }
      //  System.out.println(condition);
        return db.selectDistinct(SELLER_FETCH_ORDER.BIZ_NAME.as("bizFullName")
                ,SELLER_FETCH_ORDER.BIZ_ID).from(SELLER_FETCH_ORDER).where(condition)
                .limit(progressingSKUPage.getPageIndex(),progressingSKUPage.getPageSize())
                .fetchInto(ProgressingSKU.class);
    }

    public int getSKUCount(Long skuId){
        return db.selectCount().from(SELLER_FETCH_ORDER).where(SELLER_FETCH_ORDER.PLATFORM_SKU_ID.eq(skuId))
                .fetchInto(Integer.class).get(0);
    }

    public BigDecimal getMoney(Long skuId){
        List<BigDecimal> res = db.select(SELLER_FETCH_ORDER.REF_FETCH_PRICE).from(SELLER_FETCH_ORDER)
                .where(SELLER_FETCH_ORDER.PLATFORM_SKU_ID.eq(skuId)).fetchInto(BigDecimal.class);
        return res.stream().reduce(BigDecimal::add).orElse(BigDecimal.valueOf(0));
    }

    public Long getSkuId(String barcode){
        return db.select(SELLER_FETCH_ORDER.PLATFORM_SKU_ID).from(SELLER_FETCH_ORDER)
                .where(SELLER_FETCH_ORDER.PLATFORM_BARCODE.eq(barcode)).fetchInto(Long.class).get(0);
    }

    public List<GoodsList> getGoodsList(SystemGoodsList systemGoodsList){
        Condition condition = SELLER_FETCH_ORDER.CITY_ID.eq(systemGoodsList.getCityId());
        if(systemGoodsList.getBizFullName() != null && !systemGoodsList.getBizFullName().equals("")){
            condition = condition.and(SELLER_FETCH_ORDER.BIZ_NAME.eq(systemGoodsList.getBizFullName()));
        }
        if(systemGoodsList.getFloorId() != 0){
            condition = condition.and(SELLER_FETCH_ORDER.FLOOR_CODE.eq(systemGoodsList.getFloorId()));
        }
        if(systemGoodsList.getMarketId() != 0){
            condition = condition.and(SELLER_FETCH_ORDER.MARKET_ID.eq(systemGoodsList.getMarketId()));
        }
        if(systemGoodsList.getSpuGoodsNo() != null && !systemGoodsList.getSpuGoodsNo().equals("")){
            condition = condition.and(SELLER_FETCH_ORDER.SPU_GOODS_NO.like(systemGoodsList.getSpuGoodsNo()));
        }
        return db.select(SELLER_FETCH_ORDER.BIZ_NAME.as("bizFullName"),SELLER_FETCH_ORDER.SPU_GOODS_NO,
                SELLER_FETCH_ORDER.PLATFORM_SPU_ID.as("spuId")).from(SELLER_FETCH_ORDER).where(condition)
                .limit(systemGoodsList.getPageIndex(),systemGoodsList.getPageSize())
                .fetchInto(GoodsList.class);
    }
}
