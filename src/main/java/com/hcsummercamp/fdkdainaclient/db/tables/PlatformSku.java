/*
 * This file is generated by jOOQ.
 */
package com.hcsummercamp.fdkdainaclient.db.tables;


import com.hcsummercamp.fdkdainaclient.db.FdkForwarder4;
import com.hcsummercamp.fdkdainaclient.db.Indexes;
import com.hcsummercamp.fdkdainaclient.db.Keys;
import com.hcsummercamp.fdkdainaclient.db.tables.records.PlatformSkuRecord;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row16;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class PlatformSku extends TableImpl<PlatformSkuRecord> {

    private static final long serialVersionUID = 1812244130;

    /**
     * The reference instance of <code>fdk_forwarder4.platform_sku</code>
     */
    public static final PlatformSku PLATFORM_SKU = new PlatformSku();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PlatformSkuRecord> getRecordType() {
        return PlatformSkuRecord.class;
    }

    /**
     * The column <code>fdk_forwarder4.platform_sku.id</code>. id|郑保乐|2021-06-08
     */
    public final TableField<PlatformSkuRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "id|郑保乐|2021-06-08");

    /**
     * The column <code>fdk_forwarder4.platform_sku.spu_id</code>. SPU id|郑保乐|2021-06-08
     */
    public final TableField<PlatformSkuRecord, Long> SPU_ID = createField(DSL.name("spu_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINT)), this, "SPU id|郑保乐|2021-06-08");

    /**
     * The column <code>fdk_forwarder4.platform_sku.city_id</code>. 城市id|郑保乐|2021-06-08
     */
    public final TableField<PlatformSkuRecord, Long> CITY_ID = createField(DSL.name("city_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINT)), this, "城市id|郑保乐|2021-06-08");

    /**
     * The column <code>fdk_forwarder4.platform_sku.market_id</code>. 市场id|郑保乐|2021-06-08
     */
    public final TableField<PlatformSkuRecord, Long> MARKET_ID = createField(DSL.name("market_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINT)), this, "市场id|郑保乐|2021-06-08");

    /**
     * The column <code>fdk_forwarder4.platform_sku.floor_code</code>. 楼层编码（int）|郑保乐|2021-06-08
     */
    public final TableField<PlatformSkuRecord, Long> FLOOR_CODE = createField(DSL.name("floor_code"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINT)), this, "楼层编码（int）|郑保乐|2021-06-08");

    /**
     * The column <code>fdk_forwarder4.platform_sku.biz_id</code>. 档口表id|郑保乐|2021-06-08
     */
    public final TableField<PlatformSkuRecord, Long> BIZ_ID = createField(DSL.name("biz_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINT)), this, "档口表id|郑保乐|2021-06-08");

    /**
     * The column <code>fdk_forwarder4.platform_sku.biz_full_name</code>. 档口全称|郑保乐|2021-06-08
     */
    public final TableField<PlatformSkuRecord, String> BIZ_FULL_NAME = createField(DSL.name("biz_full_name"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "档口全称|郑保乐|2021-06-08");

    /**
     * The column <code>fdk_forwarder4.platform_sku.spu_goods_no</code>. 货号|郑保乐|2021-06-08
     */
    public final TableField<PlatformSkuRecord, String> SPU_GOODS_NO = createField(DSL.name("spu_goods_no"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "货号|郑保乐|2021-06-08");

    /**
     * The column <code>fdk_forwarder4.platform_sku.sku_name</code>. SKU名称|郑保乐|2021-06-08
     */
    public final TableField<PlatformSkuRecord, String> SKU_NAME = createField(DSL.name("sku_name"), org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "SKU名称|郑保乐|2021-06-08");

    /**
     * The column <code>fdk_forwarder4.platform_sku.ref_fetch_price</code>. 参考拿货价|郑保乐|2021-06-08
     */
    public final TableField<PlatformSkuRecord, BigDecimal> REF_FETCH_PRICE = createField(DSL.name("ref_fetch_price"), org.jooq.impl.SQLDataType.DECIMAL(19, 4).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.0000", org.jooq.impl.SQLDataType.DECIMAL)), this, "参考拿货价|郑保乐|2021-06-08");

    /**
     * The column <code>fdk_forwarder4.platform_sku.real_fetch_price</code>. 实际拿货价|郑保乐|2021-06-08
     */
    public final TableField<PlatformSkuRecord, BigDecimal> REAL_FETCH_PRICE = createField(DSL.name("real_fetch_price"), org.jooq.impl.SQLDataType.DECIMAL(19, 4).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.0000", org.jooq.impl.SQLDataType.DECIMAL)), this, "实际拿货价|郑保乐|2021-06-08");

    /**
     * The column <code>fdk_forwarder4.platform_sku.real_return_price</code>. 实际退货价|郑保乐|2021-06-08
     */
    public final TableField<PlatformSkuRecord, BigDecimal> REAL_RETURN_PRICE = createField(DSL.name("real_return_price"), org.jooq.impl.SQLDataType.DECIMAL(19, 4).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.0000", org.jooq.impl.SQLDataType.DECIMAL)), this, "实际退货价|郑保乐|2021-06-08");

    /**
     * The column <code>fdk_forwarder4.platform_sku.remarks</code>. 拿货备注|郑保乐|2021-06-13
     */
    public final TableField<PlatformSkuRecord, String> REMARKS = createField(DSL.name("remarks"), org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "拿货备注|郑保乐|2021-06-13");

    /**
     * The column <code>fdk_forwarder4.platform_sku.return_remarks</code>. 退货备注|郑保乐|2021-06-13
     */
    public final TableField<PlatformSkuRecord, String> RETURN_REMARKS = createField(DSL.name("return_remarks"), org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "退货备注|郑保乐|2021-06-13");

    /**
     * The column <code>fdk_forwarder4.platform_sku.created</code>.
     */
    public final TableField<PlatformSkuRecord, Timestamp> CREATED = createField(DSL.name("created"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>fdk_forwarder4.platform_sku.modified</code>.
     */
    public final TableField<PlatformSkuRecord, Timestamp> MODIFIED = createField(DSL.name("modified"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>fdk_forwarder4.platform_sku</code> table reference
     */
    public PlatformSku() {
        this(DSL.name("platform_sku"), null);
    }

    /**
     * Create an aliased <code>fdk_forwarder4.platform_sku</code> table reference
     */
    public PlatformSku(String alias) {
        this(DSL.name(alias), PLATFORM_SKU);
    }

    /**
     * Create an aliased <code>fdk_forwarder4.platform_sku</code> table reference
     */
    public PlatformSku(Name alias) {
        this(alias, PLATFORM_SKU);
    }

    private PlatformSku(Name alias, Table<PlatformSkuRecord> aliased) {
        this(alias, aliased, null);
    }

    private PlatformSku(Name alias, Table<PlatformSkuRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("系统规格|郑保乐|2021-06-08"));
    }

    public <O extends Record> PlatformSku(Table<O> child, ForeignKey<O, PlatformSkuRecord> key) {
        super(child, key, PLATFORM_SKU);
    }

    @Override
    public Schema getSchema() {
        return FdkForwarder4.FDK_FORWARDER4;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PLATFORM_SKU_IDX_BIZFULLNAME_SPUGOODSNO, Indexes.PLATFORM_SKU_IDX_BIZID_SPUGOODSNO, Indexes.PLATFORM_SKU_IDX_CITYID_MKTID_FLRCODE_SPUGOODSNO_BIZID, Indexes.PLATFORM_SKU_IDX_SPUID, Indexes.PLATFORM_SKU_PRIMARY);
    }

    @Override
    public Identity<PlatformSkuRecord, Long> getIdentity() {
        return Keys.IDENTITY_PLATFORM_SKU;
    }

    @Override
    public UniqueKey<PlatformSkuRecord> getPrimaryKey() {
        return Keys.KEY_PLATFORM_SKU_PRIMARY;
    }

    @Override
    public List<UniqueKey<PlatformSkuRecord>> getKeys() {
        return Arrays.<UniqueKey<PlatformSkuRecord>>asList(Keys.KEY_PLATFORM_SKU_PRIMARY);
    }

    @Override
    public PlatformSku as(String alias) {
        return new PlatformSku(DSL.name(alias), this);
    }

    @Override
    public PlatformSku as(Name alias) {
        return new PlatformSku(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PlatformSku rename(String name) {
        return new PlatformSku(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PlatformSku rename(Name name) {
        return new PlatformSku(name, null);
    }

    // -------------------------------------------------------------------------
    // Row16 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row16<Long, Long, Long, Long, Long, Long, String, String, String, BigDecimal, BigDecimal, BigDecimal, String, String, Timestamp, Timestamp> fieldsRow() {
        return (Row16) super.fieldsRow();
    }
}
