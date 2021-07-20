package com.hcsummercamp.fdkdainaclient.Entity.POJO;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/19 14:28
 * @description：POJO
 * @modified By：
 * @version: 1.0$
 */
@Data
public class PlatformSku {
    Long id;
    Long spu_id;
    Long city_id;
    Long market_id;
    Long floor_code;
    Long biz_id;        //档口表id
    String biz_full_name;       //档口全程
    String spu_goods_no;
    String sku_name;
    BigDecimal ref_fetch_price; // 参考拿货价
    BigDecimal real_fetch_price; //实际拿货价
    BigDecimal real_return_price; //实际退货价
    String remarks;     //拿货备注
    String return_remarks;  //退货备注
    Timestamp create;
    Timestamp modified;
}
