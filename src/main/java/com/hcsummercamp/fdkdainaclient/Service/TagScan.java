package com.hcsummercamp.fdkdainaclient.Service;

import com.hcsummercamp.fdkdainaclient.Dao.base_business_info_Dao;
import com.hcsummercamp.fdkdainaclient.Dao.platform_spu_Dao;
import com.hcsummercamp.fdkdainaclient.Dao.seller_fetch_order_Dao;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerFetchOrder;
import com.hcsummercamp.fdkdainaclient.Entity.Tag.TagScanInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/21 12:17
 * @description：scan tag
 * @modified By：
 * @version: 1.0$
 */
@Service
public class TagScan {
    @Autowired
    seller_fetch_order_Dao seller_fetch_order_dao;
    @Autowired
    base_business_info_Dao base_business_info_dao;
    @Autowired
    platform_spu_Dao platform_spu_dao;

    public TagScanInfo getTagInfo(String barcode){
        TagScanInfo tagScanInfo = new TagScanInfo();
        tagScanInfo.setBarcode(barcode);
        SellerFetchOrder sellerFetchOrder = seller_fetch_order_dao.getFetchOrder(barcode);
        tagScanInfo.setBizFullName(base_business_info_dao.getFullName(sellerFetchOrder.getBiz_id()));
        tagScanInfo.setMessage("扫描成功！");
        tagScanInfo.setQrCode("");
        tagScanInfo.setSellerName(sellerFetchOrder.getSeller_name());
        tagScanInfo.setSellerShortName(sellerFetchOrder.getSeller_short_name());
        tagScanInfo.setSkuName(sellerFetchOrder.getSku_name());
        tagScanInfo.setSpuGoodsNo(sellerFetchOrder.getSpu_goods_no());
        tagScanInfo.setSuccess(true);
        tagScanInfo.setImgUrl(platform_spu_dao.getUrl(sellerFetchOrder.getBiz_id(),sellerFetchOrder.getSpu_goods_no()));
        return tagScanInfo;
    }
}
