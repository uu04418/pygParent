package com.pinyougou.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class TbGoods implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5607360902312476773L;

	/** 主键*/
    private Long id;

    /** 商家ID*/
    private String seller_id;

    /** SPU名*/
    private String goods_name;

    /** 默认SKU*/
    private Long default_item_id;

    /** 状态*/
    private String audit_status;

    /** 是否上架*/
    private String is_marketable;

    /** 品牌*/
    private Long brand_id;

    /** 副标题*/
    private String caption;

    /** 一级类目*/
    private Long category1_id;

    /** 二级类目*/
    private Long category2_id;

    /** 三级类目*/
    private Long category3_id;

    /** 小图*/
    private String small_pic;

    /** 商城价*/
    private BigDecimal price;

    /** 分类模板ID*/
    private Long type_template_id;

    /** 是否启用规格*/
    private String is_enable_spec;

    /** 是否删除*/
    private String is_delete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id == null ? null : seller_id.trim();
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name == null ? null : goods_name.trim();
    }

    public Long getDefault_item_id() {
        return default_item_id;
    }

    public void setDefault_item_id(Long default_item_id) {
        this.default_item_id = default_item_id;
    }

    public String getAudit_status() {
        return audit_status;
    }

    public void setAudit_status(String audit_status) {
        this.audit_status = audit_status == null ? null : audit_status.trim();
    }

    public String getIs_marketable() {
        return is_marketable;
    }

    public void setIs_marketable(String is_marketable) {
        this.is_marketable = is_marketable == null ? null : is_marketable.trim();
    }

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
    }

    public Long getCategory1_id() {
        return category1_id;
    }

    public void setCategory1_id(Long category1_id) {
        this.category1_id = category1_id;
    }

    public Long getCategory2_id() {
        return category2_id;
    }

    public void setCategory2_id(Long category2_id) {
        this.category2_id = category2_id;
    }

    public Long getCategory3_id() {
        return category3_id;
    }

    public void setCategory3_id(Long category3_id) {
        this.category3_id = category3_id;
    }

    public String getSmall_pic() {
        return small_pic;
    }

    public void setSmall_pic(String small_pic) {
        this.small_pic = small_pic == null ? null : small_pic.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getType_template_id() {
        return type_template_id;
    }

    public void setType_template_id(Long type_template_id) {
        this.type_template_id = type_template_id;
    }

    public String getIs_enable_spec() {
        return is_enable_spec;
    }

    public void setIs_enable_spec(String is_enable_spec) {
        this.is_enable_spec = is_enable_spec == null ? null : is_enable_spec.trim();
    }

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete == null ? null : is_delete.trim();
    }
}