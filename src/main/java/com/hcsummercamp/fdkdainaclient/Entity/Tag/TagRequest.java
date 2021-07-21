package com.hcsummercamp.fdkdainaclient.Entity.Tag;

import lombok.Data;

import java.util.List;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/21 10:26
 * @description：小标签打印请求
 * @modified By：
 * @version: 1.0$
 */
@Data
public class TagRequest {
    String bizFullName;
    Long cityId;
    Long floorId;
    Long marketId;
    Long merchantId;
    int numType;    //打印数量类型：@1总数量 @2未打印数量
    boolean selectAll;//是否跨页全选；全选需要传范围，否则需要传 skuIdList
    List<Long> skuIdList;
    String spuGoodsNo;
}
