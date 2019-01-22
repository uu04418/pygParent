package com.pinyougou.pojo;

import java.io.Serializable;

public class TbContentCategory implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4834278391950820302L;

	/** 类目ID*/
    private Long id;

    /** 分类名称*/
    private String name;

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
}