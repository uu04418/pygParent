package com.pinyougou.pojo;

import java.io.Serializable;

public class TbContent implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5030938068543748718L;

	/** */
    private Long id;

    /** 内容类目ID*/
    private Long categoryId;

    /** 内容标题*/
    private String title;

    /** 链接*/
    private String url;

    /** 图片绝对路径*/
    private String pic;

    /** 状态*/
    private String status;

    /** 排序*/
    private Integer sortOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}