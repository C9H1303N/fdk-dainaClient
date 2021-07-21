package com.hcsummercamp.fdkdainaclient.Controller;

import com.hcsummercamp.fdkdainaclient.Common.page.PageContentContainer;
import com.hcsummercamp.fdkdainaclient.Dao.*;
import com.hcsummercamp.fdkdainaclient.Entity.DownloadGoodsList.GettingGoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKU;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.GoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList.SystemGoodsList;
import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.MarketOutParam;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.SellerOnPrepareSku;
import com.hcsummercamp.fdkdainaclient.Entity.GettingGoods.ProgressingSKUPage;
import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.CityOutParam;
import com.hcsummercamp.fdkdainaclient.Common.Result;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantCount;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantDetail;
import com.hcsummercamp.fdkdainaclient.Entity.Tag.*;
import com.hcsummercamp.fdkdainaclient.Service.*;
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
    AutoIncrementId autoIncrementId;
    @Autowired
    FetchOrderService fetchOrderService;
    @Autowired
    TagScan tagScan;
    @Autowired
    dainaSubmitService dainaSubmitService;

    @PostMapping("/seller/cityTree") // 已通过城市列表 已完成
    public Result<List<CityOutParam>> InquirePassedCity(){
        Result<List<CityOutParam>> res = new Result<>();
        try {
            res.setData(base_business_info_dao.findCity());       //树形查找
            res.setCode(200);
            res.setMsg("");
            return res;
        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    @PostMapping("/num/summary/list")// 销售商及数量信息
    public Result<List<MerchantDetail>> SupplierList(){
        Result<List<MerchantDetail>> res = new Result<>();
        res.setData(seller_fetch_order_dao.getMerchant());
        res.setCode(200);
        res.setMsg("");
        return res;
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

    @PostMapping("/seller/submit")      //递交 已完成
    public void dainaSubmit(@RequestBody List<SellerOnPrepareSku> sellerOnPrepareSku){
        for(SellerOnPrepareSku seller : sellerOnPrepareSku){
            dainaSubmitService.Submit(seller);
        }
    }

    @PostMapping("/find/tag/list/for/printing") //小标签查询
    public Result<List<TagInfo>> printTag(@RequestBody TagRequest tagRequest){
        Result<List<TagInfo>> res = new Result<>();

        return null;
    }

    @PostMapping("/modify/tag/print/status/to/printed") //小标签打印 已完成
    public Result<Object> updateTag(@RequestBody IdList idList){
        Result<Object> res = new Result<>();
        try {
            seller_fetch_order_dao.printTag(idList.getIdList());
            res.setCode(200);
            res.setMsg("");
        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    @PostMapping("/scan/tag/and/get/detail")        //扫描小标签  已完成
    public Result<TagScanInfo> scanTag(@RequestBody Barcode barcode){
        Result<TagScanInfo> res = new Result<>();
        if(!seller_fetch_order_dao.tagExist(barcode.getBarcode())){
            TagScanInfo tagScanInfo = new TagScanInfo();
            tagScanInfo.setSuccess(false);
            tagScanInfo.setMessage("条码不存在！");
            res.setData(tagScanInfo);
            res.setCode(200);
            res.setMsg("");
        }
        else if(seller_fetch_order_dao.scanDuplicated(barcode.getBarcode())){
            TagScanInfo tagScanInfo = new TagScanInfo();
            tagScanInfo.setSuccess(false);
            tagScanInfo.setMessage("条码已被扫描！");
            res.setData(tagScanInfo);
            res.setCode(200);
            res.setMsg("");
        }
        else {
            res.setData(tagScan.getTagInfo(barcode.getBarcode()));
            res.setCode(200);
            res.setMsg("");
            seller_fetch_order_dao.scanTag(barcode.getBarcode());
        }
        return res;
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
