package com.hcsummercamp.fdkdainaclient.Service;

import com.hcsummercamp.fdkdainaclient.Dao.base_business_info_Dao;
import com.hcsummercamp.fdkdainaclient.Dao.platform_sku_Dao;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.BaseBusinessInfo;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.PlatformSku;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerOnPrepareSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public PlatformSku getSku(SellerOnPrepareSku sellerOnPrepareSku){
        PlatformSku platformSku = new PlatformSku();
        BaseBusinessInfo baseBusinessInfo = base_business_info_dao.getInfo(sellerOnPrepareSku.getSupplierId());
        platformSku.setSpu_id(sellerOnPrepareSku.getSpuId());
        platformSku.setBiz_id(sellerOnPrepareSku.getSupplierId());
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
        return platformSku;
    }
}
