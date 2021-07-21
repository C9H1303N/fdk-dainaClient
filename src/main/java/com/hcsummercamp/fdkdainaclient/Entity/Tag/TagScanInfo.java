package com.hcsummercamp.fdkdainaclient.Entity.Tag;

import lombok.Data;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/21 10:18
 * @description：扫描小标签信息
 * @modified By：
 * @version: 1.0$
 */
@Data
public class TagScanInfo {
    String barcode;
    String bizFullName;
    String imgUrl;
    String message;
    String qrCode;
    String sellerName;
    String sellerShortName;
    String skuName;
    String spuGoodsNo;
    boolean success;
}
