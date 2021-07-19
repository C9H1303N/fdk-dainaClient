package com.hcsummercamp.fdkdainaclient.Controller;

import com.hcsummercamp.fdkdainaclient.Entity.DownloadGoodsList.GettingGoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKU;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.GoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.SystemGoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.PageContentContainer;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKUPage;
import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.CityOutParam;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantCount;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantDetail;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class dainaController {
    @PostMapping("/seller/cityTree")
    public ArrayList<CityOutParam> InquirePassedCity(){     // 已通过城市列表
        return null; // 待写
    }

    @PostMapping("/num/summary/list")
    public ArrayList<MerchantDetail> SupplierList(@RequestParam("param")MerchantCount merchantCount){    // 销售商及数量信息
        return null; // 待写
    }

    @PostMapping("/goods/num/common/list")
    public PageContentContainer<ProgressingSKU> GettingGoods(@RequestParam("param")ProgressingSKUPage progressingSKUPage){      //拿货中列表
        return null; // 待写
    }

    @PostMapping("/download/fetch/todo/list")
    public void DownloadGoodsList(@RequestParam("gettingGoodsList") GettingGoodsList gettingGoodsList){       //下载拿货单

    }

    @PostMapping("/goods/find/page")
    public PageContentContainer<GoodsList> InquireGoodsList(@RequestParam("param")SystemGoodsList systemGoodsList){  //查询货品列表
        return null; // 待写
    }
}
