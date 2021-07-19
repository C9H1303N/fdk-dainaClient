package com.hcsummercamp.fdkdainaclient.Entity.platform_sku;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/19 14:28
 * @description：数据库连接类
 * @modified By：
 * @version: 1.0$
 */
@Data
public class platform_sku {
    long id;
    long spu_id;
    long city_id;
    long market_id;
    long floor_code;
    long biz_id;        //档口表id
    String biz_full_name;       //档口全程
    String spu_goods_no;
    BigDecimal ref_fetch_price; // 参考拿货价
    BigDecimal real_fetch_price; //实际拿货价
    BigDecimal real_return_price; //实际退货价
    String remarks;     //拿货备注
    String return_remarks;  //退货备注
    Timestamp create;
    Timestamp modified;
}
