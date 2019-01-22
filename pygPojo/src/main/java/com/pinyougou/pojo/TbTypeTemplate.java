package com.pinyougou.pojo;

import java.io.Serializable;

public class TbTypeTemplate implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1046702516774608983L;

	/** */
    private Long id;

    /** 模板名称*/
    private String name;

    /** 关联规格*/
    private String spec_ids;

    /** 关联品牌*/
    private String brand_ids;

    /** 自定义属性*/
    private String custom_attribute_items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSpec_ids() {
        return spec_ids;
    }

    public void setSpec_ids(String spec_ids) {
        this.spec_ids = spec_ids == null ? null : spec_ids.trim();
    }

    public String getBrand_ids() {
        return brand_ids;
    }

    public void setBrand_ids(String brand_ids) {
        this.brand_ids = brand_ids == null ? null : brand_ids.trim();
    }

    public String getCustom_attribute_items() {
        return custom_attribute_items;
    }

    public void setCustom_attribute_items(String custom_attribute_items) {
        this.custom_attribute_items = custom_attribute_items == null ? null : custom_attribute_items.trim();
    }
}