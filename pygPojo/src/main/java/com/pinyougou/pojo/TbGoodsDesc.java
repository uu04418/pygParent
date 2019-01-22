package com.pinyougou.pojo;

import java.io.Serializable;

public class TbGoodsDesc implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6229901073758845984L;

	/** SPU_ID*/
    private Long goodsId;

    /** 描述*/
    private String introduction;

    /** 规格结果集，所有规格，包含isSelected*/
    private String specificationItems;

    /** 自定义属性（参数结果）*/
    private String customAttributeItems;

    /** */
    private String itemImages;

    /** 包装列表*/
    private String packageList;

    /** 售后服务*/
    private String saleService;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getSpecificationItems() {
        return specificationItems;
    }

    public void setSpecificationItems(String specificationItems) {
        this.specificationItems = specificationItems == null ? null : specificationItems.trim();
    }

    public String getCustomAttributeItems() {
        return customAttributeItems;
    }

    public void setCustomAttributeItems(String customAttributeItems) {
        this.customAttributeItems = customAttributeItems == null ? null : customAttributeItems.trim();
    }

    public String getItemImages() {
        return itemImages;
    }

    public void setItemImages(String itemImages) {
        this.itemImages = itemImages == null ? null : itemImages.trim();
    }

    public String getPackageList() {
        return packageList;
    }

    public void setPackageList(String packageList) {
        this.packageList = packageList == null ? null : packageList.trim();
    }

    public String getSaleService() {
        return saleService;
    }

    public void setSaleService(String saleService) {
        this.saleService = saleService == null ? null : saleService.trim();
    }
}