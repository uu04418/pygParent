package com.pinyougou.pojo;

import java.io.Serializable;

public class TbProvinces implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4860652016878329288L;

	/** 唯一ID*/
    private Integer id;

    /** 省份ID*/
    private String provinceid;

    /** 省份名称*/
    private String province;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid == null ? null : provinceid.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }
}