package com.pinyougou.pojo;

import java.io.Serializable;

public class TbContent implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1498302999316542939L;

	/** */
    private Long id;

    /** 内容类目ID*/
    private Long category_id;

    /** 内容标题*/
    private String title;

    /** 链接*/
    private String url;

    /** 图片绝对路径*/
    private String pic;

    /** 状态*/
    private String status;

    /** 排序*/
    private Integer sort_order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getSort_order() {
        return sort_order;
    }

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }
}