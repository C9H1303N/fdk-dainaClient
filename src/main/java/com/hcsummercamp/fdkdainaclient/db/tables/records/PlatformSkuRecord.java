/*
 * This file is generated by jOOQ.
 */
package com.hcsummercamp.fdkdainaclient.db.tables.records;


import com.hcsummercamp.fdkdainaclient.db.tables.PlatformSku;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record16;
import org.jooq.Row16;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 系统规格|郑保乐|2021-06-08
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PlatformSkuRecord extends UpdatableRecordImpl<PlatformSkuRecord> implements Record16<Long, Long, Long, Long, Long, Long, String, String, String, BigDecimal, BigDecimal, BigDecimal, String, String, Timestamp, Timestamp> {

    private static final long serialVersionUID = -1476478927;

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.id</code>. id|郑保乐|2021-06-08
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.id</code>. id|郑保乐|2021-06-08
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.spu_id</code>. SPU id|郑保乐|2021-06-08
     */
    public void setSpuId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.spu_id</code>. SPU id|郑保乐|2021-06-08
     */
    public Long getSpuId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.city_id</code>. 城市id|郑保乐|2021-06-08
     */
    public void setCityId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.city_id</code>. 城市id|郑保乐|2021-06-08
     */
    public Long getCityId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.market_id</code>. 市场id|郑保乐|2021-06-08
     */
    public void setMarketId(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.market_id</code>. 市场id|郑保乐|2021-06-08
     */
    public Long getMarketId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.floor_code</code>. 楼层编码（int）|郑保乐|2021-06-08
     */
    public void setFloorCode(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.floor_code</code>. 楼层编码（int）|郑保乐|2021-06-08
     */
    public Long getFloorCode() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.biz_id</code>. 档口表id|郑保乐|2021-06-08
     */
    public void setBizId(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.biz_id</code>. 档口表id|郑保乐|2021-06-08
     */
    public Long getBizId() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.biz_full_name</code>. 档口全称|郑保乐|2021-06-08
     */
    public void setBizFullName(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.biz_full_name</code>. 档口全称|郑保乐|2021-06-08
     */
    public String getBizFullName() {
        return (String) get(6);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.spu_goods_no</code>. 货号|郑保乐|2021-06-08
     */
    public void setSpuGoodsNo(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.spu_goods_no</code>. 货号|郑保乐|2021-06-08
     */
    public String getSpuGoodsNo() {
        return (String) get(7);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.sku_name</code>. SKU名称|郑保乐|2021-06-08
     */
    public void setSkuName(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.sku_name</code>. SKU名称|郑保乐|2021-06-08
     */
    public String getSkuName() {
        return (String) get(8);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.ref_fetch_price</code>. 参考拿货价|郑保乐|2021-06-08
     */
    public void setRefFetchPrice(BigDecimal value) {
        set(9, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.ref_fetch_price</code>. 参考拿货价|郑保乐|2021-06-08
     */
    public BigDecimal getRefFetchPrice() {
        return (BigDecimal) get(9);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.real_fetch_price</code>. 实际拿货价|郑保乐|2021-06-08
     */
    public void setRealFetchPrice(BigDecimal value) {
        set(10, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.real_fetch_price</code>. 实际拿货价|郑保乐|2021-06-08
     */
    public BigDecimal getRealFetchPrice() {
        return (BigDecimal) get(10);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.real_return_price</code>. 实际退货价|郑保乐|2021-06-08
     */
    public void setRealReturnPrice(BigDecimal value) {
        set(11, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.real_return_price</code>. 实际退货价|郑保乐|2021-06-08
     */
    public BigDecimal getRealReturnPrice() {
        return (BigDecimal) get(11);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.remarks</code>. 拿货备注|郑保乐|2021-06-13
     */
    public void setRemarks(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.remarks</code>. 拿货备注|郑保乐|2021-06-13
     */
    public String getRemarks() {
        return (String) get(12);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.return_remarks</code>. 退货备注|郑保乐|2021-06-13
     */
    public void setReturnRemarks(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.return_remarks</code>. 退货备注|郑保乐|2021-06-13
     */
    public String getReturnRemarks() {
        return (String) get(13);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.created</code>.
     */
    public void setCreated(Timestamp value) {
        set(14, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.created</code>.
     */
    public Timestamp getCreated() {
        return (Timestamp) get(14);
    }

    /**
     * Setter for <code>fdk_forwarder4.platform_sku.modified</code>.
     */
    public void setModified(Timestamp value) {
        set(15, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.platform_sku.modified</code>.
     */
    public Timestamp getModified() {
        return (Timestamp) get(15);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record16 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row16<Long, Long, Long, Long, Long, Long, String, String, String, BigDecimal, BigDecimal, BigDecimal, String, String, Timestamp, Timestamp> fieldsRow() {
        return (Row16) super.fieldsRow();
    }

    @Override
    public Row16<Long, Long, Long, Long, Long, Long, String, String, String, BigDecimal, BigDecimal, BigDecimal, String, String, Timestamp, Timestamp> valuesRow() {
        return (Row16) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return PlatformSku.PLATFORM_SKU.ID;
    }

    @Override
    public Field<Long> field2() {
        return PlatformSku.PLATFORM_SKU.SPU_ID;
    }

    @Override
    public Field<Long> field3() {
        return PlatformSku.PLATFORM_SKU.CITY_ID;
    }

    @Override
    public Field<Long> field4() {
        return PlatformSku.PLATFORM_SKU.MARKET_ID;
    }

    @Override
    public Field<Long> field5() {
        return PlatformSku.PLATFORM_SKU.FLOOR_CODE;
    }

    @Override
    public Field<Long> field6() {
        return PlatformSku.PLATFORM_SKU.BIZ_ID;
    }

    @Override
    public Field<String> field7() {
        return PlatformSku.PLATFORM_SKU.BIZ_FULL_NAME;
    }

    @Override
    public Field<String> field8() {
        return PlatformSku.PLATFORM_SKU.SPU_GOODS_NO;
    }

    @Override
    public Field<String> field9() {
        return PlatformSku.PLATFORM_SKU.SKU_NAME;
    }

    @Override
    public Field<BigDecimal> field10() {
        return PlatformSku.PLATFORM_SKU.REF_FETCH_PRICE;
    }

    @Override
    public Field<BigDecimal> field11() {
        return PlatformSku.PLATFORM_SKU.REAL_FETCH_PRICE;
    }

    @Override
    public Field<BigDecimal> field12() {
        return PlatformSku.PLATFORM_SKU.REAL_RETURN_PRICE;
    }

    @Override
    public Field<String> field13() {
        return PlatformSku.PLATFORM_SKU.REMARKS;
    }

    @Override
    public Field<String> field14() {
        return PlatformSku.PLATFORM_SKU.RETURN_REMARKS;
    }

    @Override
    public Field<Timestamp> field15() {
        return PlatformSku.PLATFORM_SKU.CREATED;
    }

    @Override
    public Field<Timestamp> field16() {
        return PlatformSku.PLATFORM_SKU.MODIFIED;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getSpuId();
    }

    @Override
    public Long component3() {
        return getCityId();
    }

    @Override
    public Long component4() {
        return getMarketId();
    }

    @Override
    public Long component5() {
        return getFloorCode();
    }

    @Override
    public Long component6() {
        return getBizId();
    }

    @Override
    public String component7() {
        return getBizFullName();
    }

    @Override
    public String component8() {
        return getSpuGoodsNo();
    }

    @Override
    public String component9() {
        return getSkuName();
    }

    @Override
    public BigDecimal component10() {
        return getRefFetchPrice();
    }

    @Override
    public BigDecimal component11() {
        return getRealFetchPrice();
    }

    @Override
    public BigDecimal component12() {
        return getRealReturnPrice();
    }

    @Override
    public String component13() {
        return getRemarks();
    }

    @Override
    public String component14() {
        return getReturnRemarks();
    }

    @Override
    public Timestamp component15() {
        return getCreated();
    }

    @Override
    public Timestamp component16() {
        return getModified();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getSpuId();
    }

    @Override
    public Long value3() {
        return getCityId();
    }

    @Override
    public Long value4() {
        return getMarketId();
    }

    @Override
    public Long value5() {
        return getFloorCode();
    }

    @Override
    public Long value6() {
        return getBizId();
    }

    @Override
    public String value7() {
        return getBizFullName();
    }

    @Override
    public String value8() {
        return getSpuGoodsNo();
    }

    @Override
    public String value9() {
        return getSkuName();
    }

    @Override
    public BigDecimal value10() {
        return getRefFetchPrice();
    }

    @Override
    public BigDecimal value11() {
        return getRealFetchPrice();
    }

    @Override
    public BigDecimal value12() {
        return getRealReturnPrice();
    }

    @Override
    public String value13() {
        return getRemarks();
    }

    @Override
    public String value14() {
        return getReturnRemarks();
    }

    @Override
    public Timestamp value15() {
        return getCreated();
    }

    @Override
    public Timestamp value16() {
        return getModified();
    }

    @Override
    public PlatformSkuRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value2(Long value) {
        setSpuId(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value3(Long value) {
        setCityId(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value4(Long value) {
        setMarketId(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value5(Long value) {
        setFloorCode(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value6(Long value) {
        setBizId(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value7(String value) {
        setBizFullName(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value8(String value) {
        setSpuGoodsNo(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value9(String value) {
        setSkuName(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value10(BigDecimal value) {
        setRefFetchPrice(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value11(BigDecimal value) {
        setRealFetchPrice(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value12(BigDecimal value) {
        setRealReturnPrice(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value13(String value) {
        setRemarks(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value14(String value) {
        setReturnRemarks(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value15(Timestamp value) {
        setCreated(value);
        return this;
    }

    @Override
    public PlatformSkuRecord value16(Timestamp value) {
        setModified(value);
        return this;
    }

    @Override
    public PlatformSkuRecord values(Long value1, Long value2, Long value3, Long value4, Long value5, Long value6, String value7, String value8, String value9, BigDecimal value10, BigDecimal value11, BigDecimal value12, String value13, String value14, Timestamp value15, Timestamp value16) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PlatformSkuRecord
     */
    public PlatformSkuRecord() {
        super(PlatformSku.PLATFORM_SKU);
    }

    /**
     * Create a detached, initialised PlatformSkuRecord
     */
    public PlatformSkuRecord(Long id, Long spuId, Long cityId, Long marketId, Long floorCode, Long bizId, String bizFullName, String spuGoodsNo, String skuName, BigDecimal refFetchPrice, BigDecimal realFetchPrice, BigDecimal realReturnPrice, String remarks, String returnRemarks, Timestamp created, Timestamp modified) {
        super(PlatformSku.PLATFORM_SKU);

        set(0, id);
        set(1, spuId);
        set(2, cityId);
        set(3, marketId);
        set(4, floorCode);
        set(5, bizId);
        set(6, bizFullName);
        set(7, spuGoodsNo);
        set(8, skuName);
        set(9, refFetchPrice);
        set(10, realFetchPrice);
        set(11, realReturnPrice);
        set(12, remarks);
        set(13, returnRemarks);
        set(14, created);
        set(15, modified);
    }
}
