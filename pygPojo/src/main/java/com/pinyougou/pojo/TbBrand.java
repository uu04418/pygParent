package com.pinyougou.pojo;

import java.io.Serializable;

public class TbBrand implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5517952829968493987L;

	/** */
    private Long id;

    /** 品牌名称*/
    private String name;

    /** 品牌首字母*/
    private String first_char;

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

    public String getFirst_char() {
        return first_char;
    }

    public void setFirst_char(String first_char) {
        this.first_char = first_char == null ? null : first_char.trim();
    }
}