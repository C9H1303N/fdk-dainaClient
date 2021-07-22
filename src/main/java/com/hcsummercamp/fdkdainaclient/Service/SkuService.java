package com.hcsummercamp.fdkdainaclient.Service;

import com.hcsummercamp.fdkdainaclient.Dao.base_business_info_Dao;
import com.hcsummercamp.fdkdainaclient.Dao.platform_sku_Dao;
import com.hcsummercamp.fdkdainaclient.Dao.seller_fetch_order_Dao;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.BaseBusinessInfo;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.PlatformSku;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.PlatformSpu;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerOnPrepareSku;
import com.hcsummercamp.fdkdainaclient.Entity.SKU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/20 17:24
 * @description：SkuService
 * @modified By：
 * @version: 1.0$
 */
@Service
public class SkuService {
    @Autowired
    platform_sku_Dao platform_sku_dao;
    @Autowired
    base_business_info_Dao base_business_info_dao;
    @Autowired
    seller_fetch_order_Dao seller_fetch_order_dao;

    public PlatformSku getSku(SellerOnPrepareSku sellerOnPrepareSku){
        PlatformSku platformSku = new PlatformSku();
        BaseBusinessInfo baseBusinessInfo = base_business_info_dao.getInfo(sellerOnPrepareSku.getSupplierId());
        platformSku.setSpu_id(sellerOnPrepareSku.getSpuId());
        platformSku.setBiz_id(baseBusinessInfo.getBusiness_code());
        platformSku.setCity_id(baseBusinessInfo.getCity_code());
        platformSku.setMarket_id(baseBusinessInfo.getMarket_code());
        platformSku.setFloor_code(baseBusinessInfo.getFloor_code());
        platformSku.setBiz_full_name(baseBusinessInfo.getBusiness_total_name());
        platformSku.setSpu_goods_no(sellerOnPrepareSku.getSpuGoodsNo());
        platformSku.setSku_name(sellerOnPrepareSku.getSkuName());
        platformSku.setReal_fetch_price(sellerOnPrepareSku.getPrice());
        platformSku.setRef_fetch_price(sellerOnPrepareSku.getPrice());
        platformSku.setReal_return_price(sellerOnPrepareSku.getPrice());
        platformSku.setRemarks(sellerOnPrepareSku.getRemarks());
        platformSku.setReturn_remarks("");
        platformSku.setId(sellerOnPrepareSku.getSellerSkuId());
        return platformSku;
    }

    public List<SKU> getSKU(Long bizId){
        List<SKU> skuList = platform_sku_dao.getSKU(bizId);
        for(SKU t : skuList){
            t.setAvailableNum(BigDecimal.valueOf(seller_fetch_order_dao.getSKUCount(t.getSkuId())));
            t.setToReturnNum(BigDecimal.valueOf(0));
        }
        return skuList;
    }
}
