package com.pinyougou.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class TbOrderItem implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5842623796447218902L;

	/** */
    private Long id;

    /** 商品id*/
    private Long item_id;

    /** SPU_ID*/
    private Long goods_id;

    /** 订单id*/
    private Long order_id;

    /** 商品标题*/
    private String title;

    /** 商品单价*/
    private BigDecimal price;

    /** 商品购买数量*/
    private Integer num;

    /** 商品总金额*/
    private BigDecimal total_fee;

    /** 商品图片地址*/
    private String pic_path;

    /** */
    private String seller_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
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

    public BigDecimal getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(BigDecimal total_fee) {
        this.total_fee = total_fee;
    }

    public String getPic_path() {
        return pic_path;
    }

    public void setPic_path(String pic_path) {
        this.pic_path = pic_path == null ? null : pic_path.trim();
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id == null ? null : seller_id.trim();
    }
}