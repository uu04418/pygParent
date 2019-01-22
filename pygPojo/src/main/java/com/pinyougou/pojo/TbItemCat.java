package com.pinyougou.pojo;

import java.io.Serializable;

public class TbItemCat implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -534797148496112421L;

	/** 类目ID*/
    private Long id;

    /** 父类目ID=0时，代表的是一级的类目*/
    private Long parent_id;

    /** 类目名称*/
    private String name;

    /** 类型id*/
    private Long type_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }
}