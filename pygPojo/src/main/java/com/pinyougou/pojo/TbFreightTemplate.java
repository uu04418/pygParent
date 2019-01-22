package com.pinyougou.pojo;

import java.util.Date;

public class TbFreightTemplate {
    /** */
    private Long id;

    /** 商家ID*/
    private String seller_id;

    /** 是否默认   （‘Y’是   'N'否）*/
    private String is_default;

    /** 模版名称*/
    private String name;

    /** 发货时间（1:12h  2:24h  3:48h  4:72h  5:7d 6:15d ）*/
    private String send_time_type;

    /** 统一价格*/
    private Long price;

    /** 创建时间*/
    private Date create_time;

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

    public String getIs_default() {
        return is_default;
    }

    public void setIs_default(String is_default) {
        this.is_default = is_default == null ? null : is_default.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSend_time_type() {
        return send_time_type;
    }

    public void setSend_time_type(String send_time_type) {
        this.send_time_type = send_time_type == null ? null : send_time_type.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}