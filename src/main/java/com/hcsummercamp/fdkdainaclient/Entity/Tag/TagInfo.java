package com.hcsummercamp.fdkdainaclient.Entity.Tag;

import lombok.Data;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/21 10:36
 * @description：小标签查询信息
 * @modified By：
 * @version: 1.0$
 */
@Data
public class TagInfo {
    String barcode;
    String bizFullName;
    Long id;
    String qrCode;
    String sellerShortName;
    String skuName;
    String spuGoodsNo;
}
