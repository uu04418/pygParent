package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbUser implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1418897021655036855L;

	/** */
    private Long id;

    /** 用户名*/
    private String username;

    /** 密码，加密存储*/
    private String password;

    /** 注册手机号*/
    private String phone;

    /** 注册邮箱*/
    private String email;

    /** 创建时间*/
    private Date created;

    /** */
    private Date updated;

    /** 会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat*/
    private String source_type;

    /** 昵称*/
    private String nick_name;

    /** 真实姓名*/
    private String name;

    /** 使用状态（Y正常 N非正常）*/
    private String status;

    /** 头像地址*/
    private String head_pic;

    /** QQ号码*/
    private String qq;

    /** 账户余额*/
    private Long account_balance;

    /** 手机是否验证 （0否  1是）*/
    private String is_mobile_check;

    /** 邮箱是否检测（0否  1是）*/
    private String is_email_check;

    /** 性别，1男，2女*/
    private String sex;

    /** 会员等级*/
    private Integer user_level;

    /** 积分*/
    private Integer points;

    /** 经验值*/
    private Integer experience_value;

    /** 生日*/
    private Date birthday;

    /** 最后登录时间*/
    private Date last_login_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getSource_type() {
        return source_type;
    }

    public void setSource_type(String source_type) {
        this.source_type = source_type == null ? null : source_type.trim();
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name == null ? null : nick_name.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getHead_pic() {
        return head_pic;
    }

    public void setHead_pic(String head_pic) {
        this.head_pic = head_pic == null ? null : head_pic.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Long getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(Long account_balance) {
        this.account_balance = account_balance;
    }

    public String getIs_mobile_check() {
        return is_mobile_check;
    }

    public void setIs_mobile_check(String is_mobile_check) {
        this.is_mobile_check = is_mobile_check == null ? null : is_mobile_check.trim();
    }

    public String getIs_email_check() {
        return is_email_check;
    }

    public void setIs_email_check(String is_email_check) {
        this.is_email_check = is_email_check == null ? null : is_email_check.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getUser_level() {
        return user_level;
    }

    public void setUser_level(Integer user_level) {
        this.user_level = user_level;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getExperience_value() {
        return experience_value;
    }

    public void setExperience_value(Integer experience_value) {
        this.experience_value = experience_value;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }
}