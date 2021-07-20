package com.hcsummercamp.fdkdainaclient.Service;

import com.hcsummercamp.fdkdainaclient.Dao.base_business_info_Dao;
import com.hcsummercamp.fdkdainaclient.Dao.platform_spu_Dao;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerOnPrepareSku;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.BaseBusinessInfo;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.PlatformSpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/20 16:47
 * @description：Service
 * @modified By：
 * @version: 1.0$
 */
@Service
public class SpuService {
    @Autowired
    platform_spu_Dao platform_spu_dao;
    @Autowired
    base_business_info_Dao base_business_info_dao;

    public PlatformSpu getSpu(SellerOnPrepareSku sellerOnPrepareSku){
        PlatformSpu platformSpu = new PlatformSpu();
        platformSpu.setBiz_id(sellerOnPrepareSku.getSupplierId());     //档口编码
        platformSpu.setSpu_name(sellerOnPrepareSku.getSpuName());      //spu名称
        platformSpu.setMain_img_url(sellerOnPrepareSku.getMainImgUrl());   //图片url
        platformSpu.setSpu_goods_no(sellerOnPrepareSku.getSpuGoodsNo());
        platformSpu.setTotal_fetch(BigDecimal.valueOf(0));
        platformSpu.setTotal_return(BigDecimal.valueOf(0));
        BaseBusinessInfo baseBusinessInfo = base_business_info_dao.getInfo(sellerOnPrepareSku.getSupplierId());
        platformSpu.setCity_id(baseBusinessInfo.getCity_code());
        platformSpu.setMarket_id(baseBusinessInfo.getMarket_code());
        platformSpu.setFloor_code(baseBusinessInfo.getFloor_code());
        return platformSpu;
    }
}
