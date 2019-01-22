package com.pinyougou.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class TbOrderItem implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3699869704248972972L;

	/** */
    private Long id;

    /** 商品id*/
    private Long itemId;

    /** SPU_ID*/
    private Long goodsId;

    /** 订单id*/
    private Long orderId;

    /** 商品标题*/
    private String title;

    /** 商品单价*/
    private BigDecimal price;

    /** 商品购买数量*/
    private Integer num;

    /** 商品总金额*/
    private BigDecimal totalFee;

    /** 商品图片地址*/
    private String picPath;

    /** */
    private String sellerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }
}