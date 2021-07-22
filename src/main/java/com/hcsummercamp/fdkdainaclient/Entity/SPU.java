package com.hcsummercamp.fdkdainaclient.Entity;

import com.hcsummercamp.fdkdainaclient.Entity.SKU;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SPU {
    String mainImgUrl;      //图片
    List<SKU> skuList;
    String spuGoodsNo;      //货号
    long spuId;
    String spuName;
}
