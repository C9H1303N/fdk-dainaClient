package com.hcsummercamp.fdkdainaclient.Controller;

import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.CityOutParam;
import com.hcsummercamp.fdkdainaclient.Entity.SupplierList.MerchantDetail;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class dainaController {
    @PostMapping("/seller/cityTree")
    public ArrayList<CityOutParam> InquirePassedCity(){     // 已通过城市列表
        return null; // 待写
    }

    @PostMapping("/num/summary/list")
    public ArrayList<MerchantDetail> SupplierList(){    // 销售商及数量信息
        return null; // 待写
    }
}
