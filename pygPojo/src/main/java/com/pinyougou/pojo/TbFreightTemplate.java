package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbFreightTemplate  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3577990800376142136L;

	/** */
    private Long id;

    /** 商家ID*/
    private String sellerId;

    /** 是否默认   （‘Y’是   'N'否）*/
    private String isDefault;

    /** 模版名称*/
    private String name;

    /** 发货时间（1:12h  2:24h  3:48h  4:72h  5:7d 6:15d ）*/
    private String sendTimeType;

    /** 统一价格*/
    private Long price;

    /** 创建时间*/
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSendTimeType() {
        return sendTimeType;
    }

    public void setSendTimeType(String sendTimeType) {
        this.sendTimeType = sendTimeType == null ? null : sendTimeType.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}