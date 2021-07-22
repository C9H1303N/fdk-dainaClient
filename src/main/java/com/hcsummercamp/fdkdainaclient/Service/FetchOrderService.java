package com.hcsummercamp.fdkdainaclient.Service;

import com.hcsummercamp.fdkdainaclient.Common.page.PageContent;
import com.hcsummercamp.fdkdainaclient.Common.page.PageContentContainer;
import com.hcsummercamp.fdkdainaclient.Dao.*;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKU;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKUPage;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.GoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.SystemGoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.BaseBusinessInfo;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.Seller;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerFetchOrder;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerOnPrepareSku;
import com.hcsummercamp.fdkdainaclient.Entity.SKU;
import com.hcsummercamp.fdkdainaclient.Entity.SPU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

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
    @Autowired
    SpuService spuService;
    @Autowired
    platform_spu_Dao platform_spu_dao;
    @Autowired
    platform_sku_Dao platform_sku_dao;

    public void insertFetchOrder(SellerOnPrepareSku sellerOnPrepareSku){
        BaseBusinessInfo baseBusinessInfo = base_business_info_dao.getInfo(sellerOnPrepareSku.getSupplierId());
        Seller seller = seller_dao.getInfo(sellerOnPrepareSku.getMerchantId());
        DateFormat df = new SimpleDateFormat("yyMMdd");
        Calendar calendar = Calendar.getInstance();     // N+yymmdd+自增id
        for(int i = 0; i < sellerOnPrepareSku.getPrepareNum().intValue(); i++){
            String barcode = "N" + df.format(calendar.getTime()) +
                    String.format("%06d", autoIncrementId.incr("daina"));//生成条形码
            SellerFetchOrder sellerFetchOrder = new SellerFetchOrder();
            sellerFetchOrder.setBiz_id(baseBusinessInfo.getBusiness_code());
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

    public PageContentContainer<ProgressingSKU> gettingGoodsList(ProgressingSKUPage progressingSKUPage){//拿货中列表
        List<ProgressingSKU> progressingSKUList = seller_fetch_order_dao.getProgressingSKU(progressingSKUPage);
        for(ProgressingSKU t : progressingSKUList){
            t.setSpuList(spuService.getSPU(t.getBizId()));
            int num = 0;
            int kind = 0;
            BigDecimal money = new BigDecimal(0);
            for(SPU spu : t.getSpuList()){
                kind += spu.getSkuList().size();
                for(SKU sku : spu.getSkuList()){
                    sku.setAvailableNum(BigDecimal.valueOf(seller_fetch_order_dao.getSKUCount(sku.getSkuId())));
                    sku.setToReturnNum(BigDecimal.valueOf(0));
                    num += seller_fetch_order_dao.getSKUCount(sku.getSkuId());
                    money = money.add(seller_fetch_order_dao.getMoney(sku.getSkuId()));
                }
            }
            t.setTotalKind(kind);
            t.setTotalNum(BigDecimal.valueOf(num));
            t.setMoneyAmount(money);
        }
        PageContent<ProgressingSKU> res = new PageContent<>();
        res.setList(progressingSKUList);
        res.setTotal(progressingSKUList.size());
        return res;
    }

    public PageContentContainer<GoodsList> getGoodsList(SystemGoodsList systemGoodsList){
        List<GoodsList> goodsList = seller_fetch_order_dao.getGoodsList(systemGoodsList);
        for(GoodsList t : goodsList){
            t.setMainImgUrl(platform_spu_dao.getUrl(t.getSpuGoodsNo()));
            t.setSkuList(platform_sku_dao.getSKUs(t.getSpuId()));
            int num = 0;
            for(SKU b : t.getSkuList()){
                b.setToReturnNum(BigDecimal.valueOf(0));
                num += seller_fetch_order_dao.getSKUCount(b.getSkuId());
                b.setAvailableNum(BigDecimal.valueOf(seller_fetch_order_dao.getSKUCount(b.getSkuId())));
            }
            t.setSpuFetchNum(BigDecimal.valueOf(num));
        }
        PageContent<GoodsList> res = new PageContent<>();
        res.setList(goodsList);
        res.setTotal(goodsList.size());
        return res;
    }
}
