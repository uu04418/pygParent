package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 791575766909895841L;

	/** */
    private Long id;

    /** 用户ID*/
    private String user_id;

    /** 省*/
    private String province_id;

    /** 市*/
    private String city_id;

    /** 县/区*/
    private String town_id;

    /** 手机*/
    private String mobile;

    /** 详细地址*/
    private String address;

    /** 联系人*/
    private String contact;

    /** 是否是默认 1默认 0否*/
    private String is_default;

    /** 备注*/
    private String notes;

    /** 创建日期*/
    private Date create_date;

    /** 别名*/
    private String alias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id == null ? null : province_id.trim();
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id == null ? null : city_id.trim();
    }

    public String getTown_id() {
        return town_id;
    }

    public void setTown_id(String town_id) {
        this.town_id = town_id == null ? null : town_id.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getIs_default() {
        return is_default;
    }

    public void setIs_default(String is_default) {
        this.is_default = is_default == null ? null : is_default.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }
}