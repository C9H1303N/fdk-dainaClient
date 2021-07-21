package com.hcsummercamp.fdkdainaclient.Controller;

import com.hcsummercamp.fdkdainaclient.Dao.*;
import com.hcsummercamp.fdkdainaclient.Entity.DownloadGoodsList.GettingGoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKU;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.GoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.SystemGoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.MarketOutParam;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerOnPrepareSku;
import com.hcsummercamp.fdkdainaclient.Entity.PageContentContainer;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKUPage;
import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.CityOutParam;
import com.hcsummercamp.fdkdainaclient.Entity.Result;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantCount;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantDetail;
import com.hcsummercamp.fdkdainaclient.Entity.Tag.IdList;
import com.hcsummercamp.fdkdainaclient.Entity.Tag.TagInfo;
import com.hcsummercamp.fdkdainaclient.Entity.Tag.TagRequest;
import com.hcsummercamp.fdkdainaclient.Entity.Tag.TagScanInfo;
import com.hcsummercamp.fdkdainaclient.Service.AutoIncrementId;
import com.hcsummercamp.fdkdainaclient.Service.FetchOrderService;
import com.hcsummercamp.fdkdainaclient.Service.SkuService;
import com.hcsummercamp.fdkdainaclient.Service.SpuService;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class dainaController {
    @Autowired
    seller_Dao seller_dao;
    @Autowired
    base_business_info_Dao base_business_info_dao;
    @Autowired
    seller_fetch_order_Dao seller_fetch_order_dao;
    @Autowired
    SpuService spuService;
    @Autowired
    SkuService skuService;
    @Autowired
    platform_spu_Dao platform_spu_dao;
    @Autowired
    platform_sku_Dao platform_sku_dao;
    @Autowired
    AutoIncrementId autoIncrementId;
    @Autowired
    FetchOrderService fetchOrderService;

    @PostMapping("/seller/cityTree") // 已通过城市列表
    public Result<List<CityOutParam>> InquirePassedCity(){
        Result<List<CityOutParam>> a = new Result<>();
        try {
            a.setData(base_business_info_dao.findCity());       //树形查找
            a.setCode(200);
            return a;
        } catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }

    @PostMapping("/num/summary/list")// 销售商及数量信息
    public Result<ArrayList<MerchantDetail>> SupplierList(@RequestBody MerchantCount merchantCount){
        System.out.println(merchantCount.toString());
        return null; // 待写
    }

    @PostMapping("/goods/num/common/list")//拿货中列表
    public Result<PageContentContainer<ProgressingSKU>> GettingGoods(@RequestBody ProgressingSKUPage progressingSKUPage){
        System.out.println(progressingSKUPage.toString());
        return null; // 待写
    }

    @PostMapping("/download/fetch/todo/list")  //下载拿货单
    public void DownloadGoodsList(@RequestBody GettingGoodsList gettingGoodsList){
        System.out.println(gettingGoodsList.toString());
    }

    @PostMapping("/goods/find/page")//查询货品列表
    public Result<PageContentContainer<GoodsList>> InquireGoodsList(@RequestBody SystemGoodsList systemGoodsList){
        System.out.println(systemGoodsList.toString());
        return null; // 待写
    }

    @PostMapping("/seller/submit")
    public void dainaSubmit(@RequestBody SellerOnPrepareSku sellerOnPrepareSku){
        if(!seller_dao.SellerExist(ULong.valueOf(sellerOnPrepareSku.getMerchantId()))){
            return; //如果该销售商不存在则返回
        }
        if(seller_fetch_order_dao.SellerFetchOrderExist(sellerOnPrepareSku.getMerchantId()
                ,sellerOnPrepareSku.getSellerOrderId())){
            return; //如果订单已存在则返回
        }
        if(!base_business_info_dao.BizExist(sellerOnPrepareSku.getSupplierId())){
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

    @PostMapping("/find/tag/list/for/printing") //小标签查询
    public Result<List<TagInfo>> printTag(@RequestBody TagRequest tagRequest){
        return null;
    }

    @PostMapping("/modify/tag/print/status/to/printed") //小标签打印
    public Result<Object> updateTag(@RequestBody IdList idList){
        Result<Object> res = new Result<>();
        try {
            seller_fetch_order_dao.printTag(idList.getIdList());
            res.setCode(200);
        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    @PostMapping("/scan/tag/and/get/detail")        //扫描小标签
    public Result<TagScanInfo> scanTag(@RequestBody String barcode){
        Result<TagScanInfo> res = new Result<>();
        return null;
    }

    @PostMapping("/test")
    public Result test(){
        DateFormat df = new SimpleDateFormat("yyMMdd");
        Calendar calendar = Calendar.getInstance();
        String barcode = "N" + df.format(calendar.getTime()) +
                String.format("%06d",autoIncrementId.incr("test"));//生成条形码
        System.out.println(barcode);

        Result<List<MarketOutParam>> a = new Result<>();
        return a;
    }
}
