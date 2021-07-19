package com.hcsummercamp.fdkdainaclient.Entity.seller_fetch_order;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/19 14:47
 * @description：数据库连接类
 * @modified By：
 * @version: 1.0$
 */
@Data
public class seller_fetch_order {
    long id;
    long merchant_id;
    long city_id;
    long market_id;
    long floor_code;
    long biz_id;
    String seller_order_id;
    long platform_spu_id;
    long platform_sku_id;
    long bill_id;
    String platform_sku_name;
    String seller_qr_code;
    String seller_name;
    String seller_short_name;
    String platform_barcode;
    String city_name;
    String market_name;
    String biz_name;
    String spu_goods_no;
    String sku_name;
    BigDecimal ref_fetch_price; //  参考拿货价
    BigDecimal real_fetch_price; // 实际拿货价
    int status;
    boolean tag_print_flag;  //     是否已打小标签
    boolean seller_refund_flag;  // 销售端售前退款
    Timestamp scan_time;        //  扫码到货时间
    Timestamp created;
    Timestamp modified;
}
