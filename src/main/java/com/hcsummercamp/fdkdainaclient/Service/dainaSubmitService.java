package com.hcsummercamp.fdkdainaclient.Service;

import com.hcsummercamp.fdkdainaclient.Dao.*;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerOnPrepareSku;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/21 16:03
 * @description：submit
 * @modified By：
 * @version: 1.0$
 */
@Service
public class dainaSubmitService {
    @Autowired
    seller_Dao seller_dao;
    @Autowired
    seller_fetch_order_Dao seller_fetch_order_dao;
    @Autowired
    base_business_info_Dao base_business_info_dao;
    @Autowired
    platform_spu_Dao platform_spu_dao;
    @Autowired
    platform_sku_Dao platform_sku_dao;
    @Autowired
    SpuService spuService;
    @Autowired
    SkuService skuService;
    @Autowired
    AutoIncrementId autoIncrementId;
    @Autowired
    FetchOrderService fetchOrderService;

    public void Submit(SellerOnPrepareSku sellerOnPrepareSku){
        if(!seller_dao.SellerExist(ULong.valueOf(sellerOnPrepareSku.getMerchantId()))){
            System.out.println("该销售商不存在");
            return; //如果该销售商不存在则返回
        }
        if(seller_fetch_order_dao.SellerFetchOrderExist(sellerOnPrepareSku.getMerchantId()
                ,sellerOnPrepareSku.getSellerOrderId())){
            System.out.println("订单已存在");
            return; //如果订单已存在则返回
        }
        if(!base_business_info_dao.BizExist(sellerOnPrepareSku.getSupplierId())){
            System.out.println("供货商（即档口）不存在");
            return;  //如果供货商（即档口）不存在则返回
        }
        try {
            platform_spu_dao.insertPlatSpu(spuService.getSpu(sellerOnPrepareSku));//获取并插入spu
            platform_sku_dao.insertPlatSku(skuService.getSku(sellerOnPrepareSku));//获取并插入sku
            DateFormat df = new SimpleDateFormat("yyMMdd");
            Calendar calendar = Calendar.getInstance();     // N+yymmdd+自增id
            String barcode = "N" + df.format(calendar.getTime()) +
                    String.format("%06d", autoIncrementId.incr("daina"));//生成条形码
            seller_fetch_order_dao.insertSellerFetchOrder(fetchOrderService.getFetchOrder(sellerOnPrepareSku, barcode));//插入订单
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
