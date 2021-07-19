/*
 * This file is generated by jOOQ.
 */
package com.hcsummercamp.fdkdainaclient.db.tables.records;


import com.hcsummercamp.fdkdainaclient.db.tables.BaseBusinessInfo;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record16;
import org.jooq.Row16;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 代拿市场档口商户信息表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BaseBusinessInfoRecord extends UpdatableRecordImpl<BaseBusinessInfoRecord> implements Record16<Long, Long, String, Long, String, Long, String, Long, String, String, Byte, String, String, Byte, Timestamp, Timestamp> {

    private static final long serialVersionUID = 819056288;

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.id</code>. 主键|曹瑞琪|2021年6月3日18:46:46
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.id</code>. 主键|曹瑞琪|2021年6月3日18:46:46
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.city_code</code>. 城市编码|2021年6月3日18:50:053|曹瑞琪
     */
    public void setCityCode(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.city_code</code>. 城市编码|2021年6月3日18:50:053|曹瑞琪
     */
    public Long getCityCode() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.city_name</code>. 城市名称|2021年6月3日18:50:053|曹瑞琪
     */
    public void setCityName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.city_name</code>. 城市名称|2021年6月3日18:50:053|曹瑞琪
     */
    public String getCityName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.market_code</code>. 市场编码|2021年6月3日18:50:053|曹瑞琪
     */
    public void setMarketCode(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.market_code</code>. 市场编码|2021年6月3日18:50:053|曹瑞琪
     */
    public Long getMarketCode() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.market_name</code>. 市场名称|2021年6月3日18:50:053|曹瑞琪
     */
    public void setMarketName(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.market_name</code>. 市场名称|2021年6月3日18:50:053|曹瑞琪
     */
    public String getMarketName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.floor_code</code>. 楼层编码|2021年6月3日18:50:053|曹瑞琪
     */
    public void setFloorCode(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.floor_code</code>. 楼层编码|2021年6月3日18:50:053|曹瑞琪
     */
    public Long getFloorCode() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.floor_name</code>. 楼层名称|2021年6月3日18:50:053|曹瑞琪
     */
    public void setFloorName(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.floor_name</code>. 楼层名称|2021年6月3日18:50:053|曹瑞琪
     */
    public String getFloorName() {
        return (String) get(6);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.business_code</code>. 档口编码|2021年6月3日18:50:053|曹瑞琪
     */
    public void setBusinessCode(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.business_code</code>. 档口编码|2021年6月3日18:50:053|曹瑞琪
     */
    public Long getBusinessCode() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.business_name</code>. 档口名称|2021年6月3日18:50:053|曹瑞琪
     */
    public void setBusinessName(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.business_name</code>. 档口名称|2021年6月3日18:50:053|曹瑞琪
     */
    public String getBusinessName() {
        return (String) get(8);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.business_total_name</code>. 档口全称|2021年6月3日18:50:053|曹瑞琪
     */
    public void setBusinessTotalName(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.business_total_name</code>. 档口全称|2021年6月3日18:50:053|曹瑞琪
     */
    public String getBusinessTotalName() {
        return (String) get(9);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.delete_flag</code>. 删除标记
     */
    public void setDeleteFlag(Byte value) {
        set(10, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.delete_flag</code>. 删除标记
     */
    public Byte getDeleteFlag() {
        return (Byte) get(10);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.x_coordinate</code>. 经度|2021年6月3日18:50:053|曹瑞琪
     */
    public void setXCoordinate(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.x_coordinate</code>. 经度|2021年6月3日18:50:053|曹瑞琪
     */
    public String getXCoordinate() {
        return (String) get(11);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.y_coordinate</code>. 纬度|2021年6月3日18:50:053|曹瑞琪
     */
    public void setYCoordinate(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.y_coordinate</code>. 纬度|2021年6月3日18:50:053|曹瑞琪
     */
    public String getYCoordinate() {
        return (String) get(12);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.type</code>. 商户类型|曹瑞琪|2021年6月11日16:20:33|@0 真实商户 1虚拟商户
     */
    public void setType(Byte value) {
        set(13, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.type</code>. 商户类型|曹瑞琪|2021年6月11日16:20:33|@0 真实商户 1虚拟商户
     */
    public Byte getType() {
        return (Byte) get(13);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.created</code>.
     */
    public void setCreated(Timestamp value) {
        set(14, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.created</code>.
     */
    public Timestamp getCreated() {
        return (Timestamp) get(14);
    }

    /**
     * Setter for <code>fdk_forwarder4.base_business_info.modified</code>.
     */
    public void setModified(Timestamp value) {
        set(15, value);
    }

    /**
     * Getter for <code>fdk_forwarder4.base_business_info.modified</code>.
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
    public Row16<Long, Long, String, Long, String, Long, String, Long, String, String, Byte, String, String, Byte, Timestamp, Timestamp> fieldsRow() {
        return (Row16) super.fieldsRow();
    }

    @Override
    public Row16<Long, Long, String, Long, String, Long, String, Long, String, String, Byte, String, String, Byte, Timestamp, Timestamp> valuesRow() {
        return (Row16) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.ID;
    }

    @Override
    public Field<Long> field2() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.CITY_CODE;
    }

    @Override
    public Field<String> field3() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.CITY_NAME;
    }

    @Override
    public Field<Long> field4() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.MARKET_CODE;
    }

    @Override
    public Field<String> field5() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.MARKET_NAME;
    }

    @Override
    public Field<Long> field6() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.FLOOR_CODE;
    }

    @Override
    public Field<String> field7() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.FLOOR_NAME;
    }

    @Override
    public Field<Long> field8() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.BUSINESS_CODE;
    }

    @Override
    public Field<String> field9() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.BUSINESS_NAME;
    }

    @Override
    public Field<String> field10() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.BUSINESS_TOTAL_NAME;
    }

    @Override
    public Field<Byte> field11() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.DELETE_FLAG;
    }

    @Override
    public Field<String> field12() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.X_COORDINATE;
    }

    @Override
    public Field<String> field13() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.Y_COORDINATE;
    }

    @Override
    public Field<Byte> field14() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.TYPE;
    }

    @Override
    public Field<Timestamp> field15() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.CREATED;
    }

    @Override
    public Field<Timestamp> field16() {
        return BaseBusinessInfo.BASE_BUSINESS_INFO.MODIFIED;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getCityCode();
    }

    @Override
    public String component3() {
        return getCityName();
    }

    @Override
    public Long component4() {
        return getMarketCode();
    }

    @Override
    public String component5() {
        return getMarketName();
    }

    @Override
    public Long component6() {
        return getFloorCode();
    }

    @Override
    public String component7() {
        return getFloorName();
    }

    @Override
    public Long component8() {
        return getBusinessCode();
    }

    @Override
    public String component9() {
        return getBusinessName();
    }

    @Override
    public String component10() {
        return getBusinessTotalName();
    }

    @Override
    public Byte component11() {
        return getDeleteFlag();
    }

    @Override
    public String component12() {
        return getXCoordinate();
    }

    @Override
    public String component13() {
        return getYCoordinate();
    }

    @Override
    public Byte component14() {
        return getType();
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
        return getCityCode();
    }

    @Override
    public String value3() {
        return getCityName();
    }

    @Override
    public Long value4() {
        return getMarketCode();
    }

    @Override
    public String value5() {
        return getMarketName();
    }

    @Override
    public Long value6() {
        return getFloorCode();
    }

    @Override
    public String value7() {
        return getFloorName();
    }

    @Override
    public Long value8() {
        return getBusinessCode();
    }

    @Override
    public String value9() {
        return getBusinessName();
    }

    @Override
    public String value10() {
        return getBusinessTotalName();
    }

    @Override
    public Byte value11() {
        return getDeleteFlag();
    }

    @Override
    public String value12() {
        return getXCoordinate();
    }

    @Override
    public String value13() {
        return getYCoordinate();
    }

    @Override
    public Byte value14() {
        return getType();
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
    public BaseBusinessInfoRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value2(Long value) {
        setCityCode(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value3(String value) {
        setCityName(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value4(Long value) {
        setMarketCode(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value5(String value) {
        setMarketName(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value6(Long value) {
        setFloorCode(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value7(String value) {
        setFloorName(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value8(Long value) {
        setBusinessCode(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value9(String value) {
        setBusinessName(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value10(String value) {
        setBusinessTotalName(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value11(Byte value) {
        setDeleteFlag(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value12(String value) {
        setXCoordinate(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value13(String value) {
        setYCoordinate(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value14(Byte value) {
        setType(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value15(Timestamp value) {
        setCreated(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord value16(Timestamp value) {
        setModified(value);
        return this;
    }

    @Override
    public BaseBusinessInfoRecord values(Long value1, Long value2, String value3, Long value4, String value5, Long value6, String value7, Long value8, String value9, String value10, Byte value11, String value12, String value13, Byte value14, Timestamp value15, Timestamp value16) {
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
     * Create a detached BaseBusinessInfoRecord
     */
    public BaseBusinessInfoRecord() {
        super(BaseBusinessInfo.BASE_BUSINESS_INFO);
    }

    /**
     * Create a detached, initialised BaseBusinessInfoRecord
     */
    public BaseBusinessInfoRecord(Long id, Long cityCode, String cityName, Long marketCode, String marketName, Long floorCode, String floorName, Long businessCode, String businessName, String businessTotalName, Byte deleteFlag, String xCoordinate, String yCoordinate, Byte type, Timestamp created, Timestamp modified) {
        super(BaseBusinessInfo.BASE_BUSINESS_INFO);

        set(0, id);
        set(1, cityCode);
        set(2, cityName);
        set(3, marketCode);
        set(4, marketName);
        set(5, floorCode);
        set(6, floorName);
        set(7, businessCode);
        set(8, businessName);
        set(9, businessTotalName);
        set(10, deleteFlag);
        set(11, xCoordinate);
        set(12, yCoordinate);
        set(13, type);
        set(14, created);
        set(15, modified);
    }
}
