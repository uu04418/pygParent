package com.pinyougou.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbItem implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7863241393170312573L;

	/** 商品id，同时也是商品编号*/
    private Long id;

    /** 商品标题*/
    private String title;

    /** 商品卖点*/
    private String sell_point;

    /** 商品价格，单位为：元*/
    private BigDecimal price;

    /** */
    private Integer stock_count;

    /** 库存数量*/
    private Integer num;

    /** 商品条形码*/
    private String barcode;

    /** 商品图片*/
    private String image;

    /** 所属类目，叶子类目*/
    private Long categoryId;

    /** 商品状态，1-正常，2-下架，3-删除*/
    private String status;

    /** 创建时间*/
    private Date create_time;

    /** 更新时间*/
    private Date update_time;

    /** */
    private String item_sn;

    /** */
    private BigDecimal cost_pirce;

    /** */
    private BigDecimal market_price;

    /** */
    private String is_default;

    /** */
    private Long goods_id;

    /** */
    private String seller_id;

    /** */
    private String cart_thumbnail;

    /** */
    private String category;

    /** */
    private String brand;

    /** */
    private String spec;

    /** */
    private String seller;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSell_point() {
        return sell_point;
    }

    public void setSell_point(String sell_point) {
        this.sell_point = sell_point == null ? null : sell_point.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock_count() {
        return stock_count;
    }

    public void setStock_count(Integer stock_count) {
        this.stock_count = stock_count;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getItem_sn() {
        return item_sn;
    }

    public void setItem_sn(String item_sn) {
        this.item_sn = item_sn == null ? null : item_sn.trim();
    }

    public BigDecimal getCost_pirce() {
        return cost_pirce;
    }

    public void setCost_pirce(BigDecimal cost_pirce) {
        this.cost_pirce = cost_pirce;
    }

    public BigDecimal getMarket_price() {
        return market_price;
    }

    public void setMarket_price(BigDecimal market_price) {
        this.market_price = market_price;
    }

    public String getIs_default() {
        return is_default;
    }

    public void setIs_default(String is_default) {
        this.is_default = is_default == null ? null : is_default.trim();
    }

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id == null ? null : seller_id.trim();
    }

    public String getCart_thumbnail() {
        return cart_thumbnail;
    }

    public void setCart_thumbnail(String cart_thumbnail) {
        this.cart_thumbnail = cart_thumbnail == null ? null : cart_thumbnail.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller == null ? null : seller.trim();
    }
}