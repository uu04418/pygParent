package com.pinyougou.pojo;

import java.io.Serializable;

public class TbGoodsDesc implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5211857386147468416L;

	/** SPU_ID*/
    private Long goods_id;

    /** 描述*/
    private String introduction;

    /** 规格结果集，所有规格，包含isSelected*/
    private String specification_items;

    /** 自定义属性（参数结果）*/
    private String custom_attribute_items;

    /** */
    private String item_images;

    /** 包装列表*/
    private String package_list;

    /** 售后服务*/
    private String sale_service;

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getSpecification_items() {
        return specification_items;
    }

    public void setSpecification_items(String specification_items) {
        this.specification_items = specification_items == null ? null : specification_items.trim();
    }

    public String getCustom_attribute_items() {
        return custom_attribute_items;
    }

    public void setCustom_attribute_items(String custom_attribute_items) {
        this.custom_attribute_items = custom_attribute_items == null ? null : custom_attribute_items.trim();
    }

    public String getItem_images() {
        return item_images;
    }

    public void setItem_images(String item_images) {
        this.item_images = item_images == null ? null : item_images.trim();
    }

    public String getPackage_list() {
        return package_list;
    }

    public void setPackage_list(String package_list) {
        this.package_list = package_list == null ? null : package_list.trim();
    }

    public String getSale_service() {
        return sale_service;
    }

    public void setSale_service(String sale_service) {
        this.sale_service = sale_service == null ? null : sale_service.trim();
    }
}