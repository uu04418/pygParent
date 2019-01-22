package com.pinyougou.pojo;

import java.io.Serializable;

public class TbItemCat implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1900106172247412239L;

	/** 类目ID*/
    private Long id;

    /** 父类目ID=0时，代表的是一级的类目*/
    private Long parentId;

    /** 类目名称*/
    private String name;

    /** 类型id*/
    private Long typeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}