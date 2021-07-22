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
import com.hcsummercamp.fdkdainaclient.Entity.POJO.donePrepare;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantDetail;
import com.hcsummercamp.fdkdainaclient.Entity.Tag.*;
import com.hcsummercamp.fdkdainaclient.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    @Autowired
    feignClient feignClient;

    @PostMapping("/seller/cityTree") // 已通过城市列表 已完成
    public Result<List<CityOutParam>> InquirePassedCity(){
        return Result.ok(base_business_info_dao.findCity());
    }

    @PostMapping("/num/summary/list")// 销售商及数量信息  已完成
    public Result<List<MerchantDetail>> SupplierList(){
        return Result.ok(seller_fetch_order_dao.getMerchant());
    }

    @PostMapping("/goods/num/common/list")//拿货中列表   已完成
    public Result<PageContentContainer<ProgressingSKU>> GettingGoods(@RequestBody ProgressingSKUPage progressingSKUPage){
      //  System.out.println(progressingSKUPage);
        return Result.ok(fetchOrderService.gettingGoodsList(progressingSKUPage));
    }

    @PostMapping("/download/fetch/todo/list")  //下载拿货单
    public void DownloadGoodsList(@RequestBody GettingGoodsList gettingGoodsList){
        System.out.println(gettingGoodsList.toString());
    }

    @PostMapping("/goods/find/page")//查询货品列表  已完成
    public Result<PageContentContainer<GoodsList>> InquireGoodsList(@RequestBody SystemGoodsList systemGoodsList){
        System.out.println(systemGoodsList.toString());
        return Result.ok(fetchOrderService.getGoodsList(systemGoodsList));
    }

    @PostMapping("/seller/submit")      //递交 已完成
    public void dainaSubmit(@RequestBody List<SellerOnPrepareSku> sellerOnPrepareSku){
        for(SellerOnPrepareSku seller : sellerOnPrepareSku){
            dainaSubmitService.Submit(seller);
        }
    }

    @PostMapping("/find/tag/list/for/printing") //小标签查询   已完成
    public Result<List<TagInfo>> printTag(@RequestBody TagRequest tagRequest){
        return Result.ok(seller_fetch_order_dao.getTagInfo(tagRequest));
    }

    @PostMapping("/modify/tag/print/status/to/printed") //小标签打印 已完成
    public Result<Object> updateTag(@RequestBody IdList idList){
        try {
            seller_fetch_order_dao.printTag(idList.getIdList());
        } catch (Exception e){
            e.printStackTrace();
        }
        return Result.ok();
    }

    @PostMapping("/scan/tag/and/get/detail")        //扫描小标签  已完成
    public Result<TagScanInfo> scanTag(@RequestBody Barcode barcode){
        if(!seller_fetch_order_dao.tagExist(barcode.getBarcode())){
            TagScanInfo tagScanInfo = new TagScanInfo();
            tagScanInfo.setSuccess(false);
            tagScanInfo.setMessage("条码不存在！");
            return Result.ok(tagScanInfo);
        }
        else if(seller_fetch_order_dao.scanDuplicated(barcode.getBarcode())){
            TagScanInfo tagScanInfo = new TagScanInfo();
            tagScanInfo.setSuccess(false);
            tagScanInfo.setMessage("条码已被扫描！");
            return Result.ok(tagScanInfo);
        }
        else {
            seller_fetch_order_dao.scanTag(barcode.getBarcode());
            donePrepare donePrepare = new donePrepare();
            donePrepare.setSkuId(seller_fetch_order_dao.getSkuId(barcode.getBarcode()));
            donePrepare.setDonePrepareNum(BigDecimal.ONE);
            feignClient.donePrepare(donePrepare);
            return Result.ok(tagScan.getTagInfo(barcode.getBarcode()));
        }
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
