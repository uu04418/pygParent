package com.pinyougou.pojo;

import java.io.Serializable;

public class TbSpecificationOption implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5560956802807011532L;

	/** 规格项ID*/
    private Long id;

    /** 规格项名称*/
    private String option_name;

    /** 规格ID*/
    private Long spec_id;

    /** 排序值*/
    private Integer orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption_name() {
        return option_name;
    }

    public void setOption_name(String option_name) {
        this.option_name = option_name == null ? null : option_name.trim();
    }

    public Long getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(Long spec_id) {
        this.spec_id = spec_id;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}