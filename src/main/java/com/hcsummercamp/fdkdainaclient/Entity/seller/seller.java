package com.hcsummercamp.fdkdainaclient.Entity.seller;

import lombok.Data;
import org.jooq.types.ULong;

import java.sql.Timestamp;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/19 14:40
 * @description：POJO
 * @modified By：
 * @version: 1.0$
 */
@Data
public class seller {
    ULong id;
    String platform_code;     //销售商来源平台
    long platform_identity;     //销售商唯一id
    String name;
    String short_name;
    String user_name;
    String user_phone;
    int province;       //省
    int city;       //市
    int district;       //区
    String area;        //省市区名称
    String address;         //详细地址
    int status;     //状态|@0:默认值、有效；@1：已删除状态；
    Timestamp created;
    Timestamp modified;
}
