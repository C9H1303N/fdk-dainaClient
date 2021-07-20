package com.hcsummercamp.fdkdainaclient.Controller;

import com.hcsummercamp.fdkdainaclient.Dao.base_business_info_Dao;
import com.hcsummercamp.fdkdainaclient.Dao.seller_Dao;
import com.hcsummercamp.fdkdainaclient.Entity.DownloadGoodsList.GettingGoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKU;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.GoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.SystemGoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.MarketOutParam;
import com.hcsummercamp.fdkdainaclient.Entity.PageContentContainer;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKUPage;
import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.CityOutParam;
import com.hcsummercamp.fdkdainaclient.Entity.Result;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantCount;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantDetail;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class dainaController {
    @Autowired
    seller_Dao seller_dao;
    @Autowired
    base_business_info_Dao base_business_info_dao;

    @PostMapping("/seller/cityTree") // 已通过城市列表
    public Result<List<CityOutParam>> InquirePassedCity(){
        Result<List<CityOutParam>> a = new Result<>();
        try {
            a.setData(base_business_info_dao.findCity());
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
    public void dainaSubmit(seller seller){

    }

    @PostMapping("/test")
    public Result test(){
        Result<List<MarketOutParam>> a = new Result<>();
        try {
            a.setData(base_business_info_dao.findMarket(440100L));
            a.setCode(200);
            return a;
        } catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }
}
