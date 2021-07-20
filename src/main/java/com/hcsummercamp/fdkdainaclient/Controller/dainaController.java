package com.hcsummercamp.fdkdainaclient.Controller;

import com.hcsummercamp.fdkdainaclient.Dao.*;
import com.hcsummercamp.fdkdainaclient.Entity.DownloadGoodsList.GettingGoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKU;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.GoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.SystemGoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.MarketOutParam;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerOnPrepareSku;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.PlatformSpu;
import com.hcsummercamp.fdkdainaclient.Entity.PageContentContainer;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKUPage;
import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.CityOutParam;
import com.hcsummercamp.fdkdainaclient.Entity.Result;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantCount;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantDetail;
import com.hcsummercamp.fdkdainaclient.Service.AutoIncrementId;
import com.hcsummercamp.fdkdainaclient.Service.SkuService;
import com.hcsummercamp.fdkdainaclient.Service.SpuService;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
        platform_spu_dao.insertPlatSpu(spuService.getSpu(sellerOnPrepareSku));//获取spu
        platform_sku_dao.insertPlatSku(skuService.getSku(sellerOnPrepareSku));//获取sku

    }

    @PostMapping("/test")
    public Result test(){
        System.out.println();
        Result<List<MarketOutParam>> a = new Result<>();
        return a;
    }
}
