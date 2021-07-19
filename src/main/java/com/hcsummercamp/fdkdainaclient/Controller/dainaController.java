package com.hcsummercamp.fdkdainaclient.Controller;

import com.hcsummercamp.fdkdainaclient.Entity.DownloadGoodsList.GettingGoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKU;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.GoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.SystemGoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.PageContentContainer;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKUPage;
import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.CityOutParam;
import com.hcsummercamp.fdkdainaclient.Entity.Result;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantCount;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantDetail;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class dainaController {
    @PostMapping("/seller/cityTree")
    public Result<ArrayList<CityOutParam>> InquirePassedCity(){     // 已通过城市列表
        return null; // 待写
    }

    @PostMapping("/num/summary/list")
    public Result<ArrayList<MerchantDetail>> SupplierList(@RequestBody MerchantCount merchantCount){    // 销售商及数量信息
        System.out.println(merchantCount.toString());
        return null; // 待写
    }

    @PostMapping("/goods/num/common/list")
    public Result<PageContentContainer<ProgressingSKU>> GettingGoods(@RequestBody ProgressingSKUPage progressingSKUPage){      //拿货中列表
        System.out.println(progressingSKUPage.toString());
        return null; // 待写
    }

    @PostMapping("/download/fetch/todo/list")
    public void DownloadGoodsList(@RequestBody GettingGoodsList gettingGoodsList){       //下载拿货单
        System.out.println(gettingGoodsList.toString());
    }

    @PostMapping("/goods/find/page")
    public Result<PageContentContainer<GoodsList>> InquireGoodsList(@RequestBody SystemGoodsList systemGoodsList){  //查询货品列表
        System.out.println(systemGoodsList.toString());
        return null; // 待写
    }
}
