package com.hcsummercamp.fdkdainaclient.Entity.InquireGoodsList;

import com.hcsummercamp.fdkdainaclient.Entity.SKU;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Data
public class GoodsList {
    String bizFullName; //档口全称
    String mainImgUrl; //图片
    List<SKU> skuList;
    BigDecimal spuFetchNum;//SPU 拿货数量
    String spuGoodsNo; // 货号
    long spuId;
    BigDecimal spuReturnNum; //SPU 退货数量
}
