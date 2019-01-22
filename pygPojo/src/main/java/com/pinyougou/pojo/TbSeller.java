package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbSeller implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8958261281208596163L;

	/** 用户ID*/
    private String seller_id;

    /** 公司名*/
    private String name;

    /** 店铺名称*/
    private String nick_name;

    /** 密码*/
    private String password;

    /** EMAIL*/
    private String email;

    /** 公司手机*/
    private String mobile;

    /** 公司电话*/
    private String telephone;

    /** 状态*/
    private String status;

    /** 详细地址*/
    private String address_detail;

    /** 联系人姓名*/
    private String linkman_name;

    /** 联系人QQ*/
    private String linkman_qq;

    /** 联系人电话*/
    private String linkman_mobile;

    /** 联系人EMAIL*/
    private String linkman_email;

    /** 营业执照号*/
    private String license_number;

    /** 税务登记证号*/
    private String tax_number;

    /** 组织机构代码*/
    private String org_number;

    /** 公司地址*/
    private Long address;

    /** 公司LOGO图*/
    private String logo_pic;

    /** 简介*/
    private String brief;

    /** 创建日期*/
    private Date create_time;

    /** 法定代表人*/
    private String legal_person;

    /** 法定代表人身份证*/
    private String legal_person_card_id;

    /** 开户行账号名称*/
    private String bank_user;

    /** 开户行*/
    private String bank_name;

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id == null ? null : seller_id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name == null ? null : nick_name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(String address_detail) {
        this.address_detail = address_detail == null ? null : address_detail.trim();
    }

    public String getLinkman_name() {
        return linkman_name;
    }

    public void setLinkman_name(String linkman_name) {
        this.linkman_name = linkman_name == null ? null : linkman_name.trim();
    }

    public String getLinkman_qq() {
        return linkman_qq;
    }

    public void setLinkman_qq(String linkman_qq) {
        this.linkman_qq = linkman_qq == null ? null : linkman_qq.trim();
    }

    public String getLinkman_mobile() {
        return linkman_mobile;
    }

    public void setLinkman_mobile(String linkman_mobile) {
        this.linkman_mobile = linkman_mobile == null ? null : linkman_mobile.trim();
    }

    public String getLinkman_email() {
        return linkman_email;
    }

    public void setLinkman_email(String linkman_email) {
        this.linkman_email = linkman_email == null ? null : linkman_email.trim();
    }

    public String getLicense_number() {
        return license_number;
    }

    public void setLicense_number(String license_number) {
        this.license_number = license_number == null ? null : license_number.trim();
    }

    public String getTax_number() {
        return tax_number;
    }

    public void setTax_number(String tax_number) {
        this.tax_number = tax_number == null ? null : tax_number.trim();
    }

    public String getOrg_number() {
        return org_number;
    }

    public void setOrg_number(String org_number) {
        this.org_number = org_number == null ? null : org_number.trim();
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
    }

    public String getLogo_pic() {
        return logo_pic;
    }

    public void setLogo_pic(String logo_pic) {
        this.logo_pic = logo_pic == null ? null : logo_pic.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getLegal_person() {
        return legal_person;
    }

    public void setLegal_person(String legal_person) {
        this.legal_person = legal_person == null ? null : legal_person.trim();
    }

    public String getLegal_person_card_id() {
        return legal_person_card_id;
    }

    public void setLegal_person_card_id(String legal_person_card_id) {
        this.legal_person_card_id = legal_person_card_id == null ? null : legal_person_card_id.trim();
    }

    public String getBank_user() {
        return bank_user;
    }

    public void setBank_user(String bank_user) {
        this.bank_user = bank_user == null ? null : bank_user.trim();
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name == null ? null : bank_name.trim();
    }
}