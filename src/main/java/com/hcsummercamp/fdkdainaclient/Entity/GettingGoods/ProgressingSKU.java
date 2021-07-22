package com.hcsummercamp.fdkdainaclient.Entity.GettingGoods;

import com.hcsummercamp.fdkdainaclient.Entity.SPU;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProgressingSKU {       //待拿、拿中、已拿未结、代退、退中 sku
    String bizFullName;     //档口全称
    long bizId;     // 档口 id
    BigDecimal moneyAmount;
    List<SPU> spuList;
    int totalKind;      //种类
    BigDecimal totalNum;   //数量
}
