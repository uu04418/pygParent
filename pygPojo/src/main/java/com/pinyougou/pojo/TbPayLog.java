package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbPayLog implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2738304543382986395L;

	/** 支付订单号*/
    private String out_trade_no;

    /** 创建日期*/
    private Date create_time;

    /** 支付完成时间*/
    private Date pay_time;

    /** 支付金额（分）*/
    private Long total_fee;

    /** 用户ID*/
    private String user_id;

    /** 交易号码*/
    private String transaction_id;

    /** 交易状态*/
    private String trade_state;

    /** 订单编号列表*/
    private String order_list;

    /** 支付类型*/
    private String pay_type;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no == null ? null : out_trade_no.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getPay_time() {
        return pay_time;
    }

    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }

    public Long getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Long total_fee) {
        this.total_fee = total_fee;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id == null ? null : transaction_id.trim();
    }

    public String getTrade_state() {
        return trade_state;
    }

    public void setTrade_state(String trade_state) {
        this.trade_state = trade_state == null ? null : trade_state.trim();
    }

    public String getOrder_list() {
        return order_list;
    }

    public void setOrder_list(String order_list) {
        this.order_list = order_list == null ? null : order_list.trim();
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type == null ? null : pay_type.trim();
    }
}