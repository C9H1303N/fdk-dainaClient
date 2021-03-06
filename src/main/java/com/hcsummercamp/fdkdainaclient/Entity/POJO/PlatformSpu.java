package com.hcsummercamp.fdkdainaclient.Entity.POJO;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/19 14:36
 * @description：POJO
 * @modified By：
 * @version: 1.0$
 */
@Data
public class PlatformSpu {
    Long id;
    Long city_id;
    Long market_id;
    Long floor_code;
    Long biz_id;
    String spu_name;
    String main_img_url;        // 图片url
    String spu_goods_no;        //  货号
    BigDecimal total_fetch;         //  总已拿货结账数量
    BigDecimal total_return;        //  总已退货结账数量
    Timestamp created;
    Timestamp modified;
}
