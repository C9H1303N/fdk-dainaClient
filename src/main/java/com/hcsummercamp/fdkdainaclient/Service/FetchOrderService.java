package com.hcsummercamp.fdkdainaclient.Service;

import com.hcsummercamp.fdkdainaclient.Dao.base_business_info_Dao;
import com.hcsummercamp.fdkdainaclient.Dao.seller_Dao;
import com.hcsummercamp.fdkdainaclient.Dao.seller_fetch_order_Dao;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.BaseBusinessInfo;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.Seller;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerFetchOrder;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerOnPrepareSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/21 9:35
 * @description：生成订单项
 * @modified By：
 * @version: 1.0$
 */
@Service
public class FetchOrderService {
    @Autowired
    seller_fetch_order_Dao seller_fetch_order_dao;
    @Autowired
    base_business_info_Dao base_business_info_dao;
    @Autowired
    seller_Dao seller_dao;
    @Autowired
    AutoIncrementId autoIncrementId;

    public void insertFetchOrder(SellerOnPrepareSku sellerOnPrepareSku){
        BaseBusinessInfo baseBusinessInfo = base_business_info_dao.getInfo(sellerOnPrepareSku.getSupplierId());
        Seller seller = seller_dao.getInfo(sellerOnPrepareSku.getMerchantId());
        DateFormat df = new SimpleDateFormat("yyMMdd");
        Calendar calendar = Calendar.getInstance();     // N+yymmdd+自增id
        for(int i = 0; i < sellerOnPrepareSku.getPrepareNum().intValue(); i++){
            String barcode = "N" + df.format(calendar.getTime()) +
                    String.format("%06d", autoIncrementId.incr("daina"));//生成条形码
            SellerFetchOrder sellerFetchOrder = new SellerFetchOrder();
            sellerFetchOrder.setBiz_id(sellerOnPrepareSku.getSupplierId());
            sellerFetchOrder.setMerchant_id(sellerOnPrepareSku.getMerchantId());
            sellerFetchOrder.setCity_id(baseBusinessInfo.getCity_code());
            sellerFetchOrder.setMarket_id(baseBusinessInfo.getMarket_code());
            sellerFetchOrder.setFloor_code(baseBusinessInfo.getFloor_code());
            sellerFetchOrder.setSeller_order_id(sellerOnPrepareSku.getSellerOrderId());
            sellerFetchOrder.setPlatform_spu_id(sellerOnPrepareSku.getSpuId());
            sellerFetchOrder.setPlatform_sku_id(sellerOnPrepareSku.getSellerSkuId());
            sellerFetchOrder.setBill_id(0L);
            sellerFetchOrder.setPlatform_sku_name(sellerOnPrepareSku.getSkuName());
            sellerFetchOrder.setSeller_qr_code("");
            sellerFetchOrder.setSeller_name(seller.getName());
            sellerFetchOrder.setSeller_short_name(seller.getShort_name());
            sellerFetchOrder.setPlatform_barcode(barcode);
            sellerFetchOrder.setCity_name(baseBusinessInfo.getCity_name());
            sellerFetchOrder.setMarket_name(baseBusinessInfo.getMarket_name());
            sellerFetchOrder.setBiz_name(baseBusinessInfo.getBusiness_name());
            sellerFetchOrder.setSpu_goods_no(sellerOnPrepareSku.getSpuGoodsNo());
            sellerFetchOrder.setSku_name(sellerOnPrepareSku.getSkuName());
            sellerFetchOrder.setRef_fetch_price(sellerOnPrepareSku.getPrice());
            sellerFetchOrder.setReal_fetch_price(sellerOnPrepareSku.getPrice());
            sellerFetchOrder.setStatus(1);//拿货中
            sellerFetchOrder.setTag_print_flag(false);//还未打印
            sellerFetchOrder.setSeller_refund_flag(false);
            try {
                seller_fetch_order_dao.insertSellerFetchOrder(sellerFetchOrder);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
