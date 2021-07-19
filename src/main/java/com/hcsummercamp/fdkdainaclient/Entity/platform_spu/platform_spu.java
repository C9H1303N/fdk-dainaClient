package com.hcsummercamp.fdkdainaclient.Entity.platform_spu;

import lombok.Data;
import org.jooq.types.ULong;

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
public class platform_spu {
    ULong id;
    ULong city_id;
    ULong market_id;
    ULong floor_code;
    ULong biz_id;
    String spu_name;
    String main_img_url;        // 图片url
    String spu_goods_no;        //  货号
    BigDecimal total_fetch;         //  总已拿货结账数量
    BigDecimal total_return;        //  总已退货结账数量
    Timestamp created;
    Timestamp modified;
}
