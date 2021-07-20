package com.hcsummercamp.fdkdainaclient.Entity.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author YellowSugar
 * @date 2021/7/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerOnPrepareSku {
    Long id;
    Long merchantId;
    Long supplierId;
    Long sellerSkuId;
    BigDecimal prepareNum;
    Timestamp created;
    Timestamp modified;
    BigDecimal wishMorePrepareNum;
    BigDecimal priorPrepareNum;
    Short takeGoodsType;
    BigDecimal price;
    String remarks; // 拿货备注
    Long spuId;
    String spuGoodsNo; // 货号
    String skuName;
    String spuName;
    String mainImgUrl;
    String sellerOrderId;       //销端子单id
}
