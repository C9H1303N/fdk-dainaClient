package com.hcsummercamp.fdkdainaclient.Entity.POJO;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/19 17:34
 * @description：POJO
 * @modified By：
 * @version: 1.0$
 */
@Data
public class base_business_info {
    Long id;
    Long city_code;
    String city_name;
    Long market_code;
    String market_name;
    Long floor_code;
    String floor_name;
    Long business_code;
    String business_name;
    String business_total_name;
    int delete_flag;
    String x_coordinate;  //经度
    String y_coordinate;
    int type;   //商户类型
    Timestamp created;
    Timestamp modified;
}
