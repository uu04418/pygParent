package com.pinyougou.pojo;

import java.io.Serializable;

public class TbSpecification implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6438842771705733814L;

	/** 主键*/
    private Long id;

    /** 名称*/
    private String spec_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpec_name() {
        return spec_name;
    }

    public void setSpec_name(String spec_name) {
        this.spec_name = spec_name == null ? null : spec_name.trim();
    }
}